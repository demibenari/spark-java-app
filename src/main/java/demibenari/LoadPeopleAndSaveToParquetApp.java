package demibenari;

import demibenari.entities.Person;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

import java.util.List;

/**
 *
 * Created by Demi Ben-Ari on 4/2/16.
 */
public class LoadPeopleAndSaveToParquetApp {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName("WordCountSaveToParquet")
                                             .setMaster("local[2]");

        JavaSparkContext ctx = new JavaSparkContext(sparkConf);
        SQLContext sqlContext = new SQLContext(ctx);

        System.out.println("=== Data source: RDD ===");
        // Load a text file and convert each line to a Java Bean.
        JavaRDD<Person> people = ctx.textFile("src/main/resources/people.txt").map(
                new Function<String, Person>() {
                    @Override
                    public Person call(String line) {
                        String[] parts = line.split(",");

                        Person person = new Person();
                        person.setName(parts[0]);
                        person.setAge(Integer.parseInt(parts[1].trim()));

                        return person;
                    }
                });

        // Apply a schema to an RDD of Java Beans and register it as a table.
        DataFrame schemaPeople = sqlContext.createDataFrame(people, Person.class);
        schemaPeople.registerTempTable("people");

        // SQL can be run over RDDs that have been registered as tables.
        DataFrame teenagers = sqlContext.sql("SELECT name FROM people WHERE age >= 13 AND age <= 19");

        // The results of SQL queries are DataFrames and support all the normal RDD operations.
        // The columns of a row in the result can be accessed by ordinal.
        List<String> teenagerNames = teenagers.toJavaRDD().map(new Function<Row, String>() {
            @Override
            public String call(Row row) {
                return "Name: " + row.getString(0);
            }
        }).collect();

        for (String name: teenagerNames) {
            System.out.println(name);
        }

        System.out.println("=== Data source: Parquet File ===");
        // DataFrames can be saved as parquet files, maintaining the schema information.

        schemaPeople.write()
                    .parquet("file:///tmp/parquet");


        // Read in the parquet file created above.
        // Parquet files are self-describing so the schema is preserved.
        // The result of loading a parquet file is also a DataFrame.
        DataFrame parquetFile = sqlContext.read()
                                          .parquet("file:///tmp/parquet");

        //Parquet files can also be registered as tables and then used in SQL statements.
        parquetFile.registerTempTable("parquetFile");
        DataFrame teenagers2 =
                sqlContext.sql("SELECT name FROM parquetFile WHERE age >= 13 AND age <= 19");
        teenagerNames = teenagers2.toJavaRDD().map(new Function<Row, String>() {
            @Override
            public String call(Row row) {
                return "Name: " + row.getString(0);
            }
        }).collect();
        for (String name: teenagerNames) {
            System.out.println(name);
        }

        ctx.stop();
    }
}
