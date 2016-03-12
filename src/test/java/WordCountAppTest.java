import org.junit.Test;

/**
 *
 * Created by Demi Ben-Ari on 3/12/16.
 */

public class WordCountAppTest {
    @Test
    public void test() {
        String pathToInputFile = "file:///tmp/file.txt";
        String pathToOutputFile = "file:///tmp/counts.txt";

        String[] args = { pathToInputFile, pathToOutputFile };

        WordCountApp.main(args);
    }
}
