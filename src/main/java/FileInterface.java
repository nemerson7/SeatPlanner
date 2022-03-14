import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Used to define file interface expected by program, done to decouple file processing
 * (which could change with the problem) from interface that rest of application will use
 */

public interface FileInterface {

    /**
     *
     * @param filePath input filepath which will be read
     * @return String data read from file
     */
    public String readAndParseToArrangement(String filePath) throws FileNotFoundException;

    /**
     *
     * @param writeData data to be written to file
     * @param filePath path to where the data will be written
     */
    public void writeArrangementToPath(String writeData, String filePath) throws IOException;

}
