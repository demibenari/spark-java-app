package demibenari.functions;

import org.junit.Test;
import scala.Tuple2;

import static org.junit.Assert.assertEquals;

/**
 *
 * Created by Demi Ben-Ari on 3/12/16.
 */
public class WordMapperPairFunctionTest {
    @Test
    public void testSimple() throws Exception {
        WordMapperPairFunction function = new WordMapperPairFunction();
        Tuple2<String, Integer> result = function.call("First");

        assertEquals("Wrong first variable", "First", result._1);
        assertEquals("Wrong Second variable", new Integer(1), result._2);
    }
}
