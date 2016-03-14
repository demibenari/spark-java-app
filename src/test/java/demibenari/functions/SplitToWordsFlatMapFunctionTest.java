package demibenari.functions;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 *
 * Created by Demi Ben-Ari on 3/12/16.
 */
public class SplitToWordsFlatMapFunctionTest {
    @Test
    public void testSimple() throws Exception {
        SplitToWordsFlatMapFunction function = new SplitToWordsFlatMapFunction();

        Iterable<String> result = function.call("Some String");

        List<String> output = Lists.newArrayList(result);

        assertEquals("Wrong size", 2, output.size());
        assertEquals("Wrong first word", "Some", output.get(0));
        assertEquals("Wrong second word", "String", output.get(1));

    }
}
