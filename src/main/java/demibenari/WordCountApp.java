package demibenari;

import demibenari.functions.SplitToWordsFlatMapFunction;
import demibenari.functions.WordMapperPairFunction;
import demibenari.functions.WordReducerFunction;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 *
 * Created by Demi Ben-Ari on 3/12/16.
 */
public class WordCountApp {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Please provide the input file full path as argument");
            System.exit(0);
        }

        SparkConf conf = new SparkConf().setAppName("WordCountApp")
                                        .setMaster("local[2]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> file = sc.textFile(args[0]);

        JavaPairRDD<String, Integer> counter = file.flatMap(new SplitToWordsFlatMapFunction())
                                                   .mapToPair(new WordMapperPairFunction())
                                                   .reduceByKey(new WordReducerFunction());

        counter.saveAsTextFile(args[1]);
    }
}
