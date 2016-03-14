package demibenari.functions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * Created by Demi Ben-Ari on 3/12/16.
 */
public class WordReducerFunctionTest {
    @Test
    public void testSimple() throws Exception {
        WordReducerFunction function = new WordReducerFunction();
        Integer result = function.call(1, 1);
        assertEquals("Reduce result is wrong", new Integer(2), result);
    }

}
