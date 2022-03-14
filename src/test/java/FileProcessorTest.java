import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileProcessorTest {


    final String IN_PATH1 = new File("./input-tests/test1.txt").getCanonicalPath();
    final String IN_PATH2 = new File("./input-tests/test2.txt").getCanonicalPath();
    final String IN_PATH3 = new File("./input-tests/test3.txt").getCanonicalPath();
    final String OUT_PATH1 = new File("./input-tests/test-out1.txt").getCanonicalPath();

    FileProcessor processor;

    public FileProcessorTest() throws IOException {
        this.processor = new FileProcessor();
    }

    @Test
    public void testInputParsing() throws FileNotFoundException {
        assertEquals(processor.readAndParseToArrangement(IN_PATH1), """
                R001 2
                R002 4
                R003 4
                R004 10
                """);

        assertEquals(processor.readAndParseToArrangement(IN_PATH2), """
                R001 2
                R002 4
                R003 4
                R004 10
                R005 20
                """);
        assertEquals(processor.readAndParseToArrangement(IN_PATH3), """
                R001 2
                R002 4
                R003 4
                R004 9999
                """);
    }

    public void testOutputWriting() throws IOException {
        String testText = "test";
        processor.writeArrangementToPath(testText, OUT_PATH1);
        assertEquals(processor.readAndParseToArrangement(OUT_PATH1), testText);
    }

}