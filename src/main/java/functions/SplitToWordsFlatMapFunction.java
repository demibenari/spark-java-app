package functions;

import org.apache.spark.api.java.function.FlatMapFunction;

import java.util.Arrays;

/**
 *
 * Created by Demi Ben-Ari on 3/12/16.
 */
public class SplitToWordsFlatMapFunction implements FlatMapFunction<String, String> {
    @Override
    public Iterable<String> call(String s) throws Exception {
        return Arrays.asList(s.split(" "));
    }
}
