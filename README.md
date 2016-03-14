Sample Java Maven Spark application
============================

# spark-java-app
### Input parameters:
1) Input file location (eg. "file:///tmp/file.txt")

2) Output location (eg. "hdfs:///tmp/output")

```
$SPARK_HOME/bin/spark-submit --class demibenari.WordCountApp \
    --master yarn-client \
    --num-executors 1 \
    --executor-cores 1 \
    --driver-memory 512m \
    /tmp/word-count-app-1.0-SNAPSHOT.jar \
    file:///tmp/file.txt \ 
    hdfs:///tmp/output
```




