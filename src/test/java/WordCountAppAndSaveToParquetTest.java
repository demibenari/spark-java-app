import demibenari.WordCountAppAndSaveToParquet;
import org.junit.Test;

/**
 *
 * Created by Demi Ben-Ari on 4/2/16.
 */
public class WordCountAppAndSaveToParquetTest {
    @Test
    public void test() {
//        String pathToInputFile = "file:///tmp/file.txt";
//        String pathToOutputFile = "file:///tmp/counts.txt";
//
//        String[] args = { pathToInputFile, pathToOutputFile };
        String[] args = {  };

        WordCountAppAndSaveToParquet.main(args);
    }
}
