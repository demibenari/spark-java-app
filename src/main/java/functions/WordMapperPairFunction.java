package functions;

import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

/**
 *
 * Created by Demi Ben-Ari on 3/12/16.
 */
public class WordMapperPairFunction implements PairFunction<String, String, Integer> {
    @Override
    public Tuple2<String, Integer> call(String s) throws Exception {
        return new Tuple2<>(s, 1);
    }
}
