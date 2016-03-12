package functions;

import org.apache.spark.api.java.function.Function2;

/**
 *
 * Created by Demi Ben-Ari on 3/12/16.
 */
public class WordReducerFunction implements Function2<Integer, Integer, Integer> {
    @Override
    public Integer call(Integer a, Integer b) throws Exception {
        return a + b;
    }
}
