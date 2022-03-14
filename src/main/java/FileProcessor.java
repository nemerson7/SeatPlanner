import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Only one instance, utilized by Main to read and parse file input and write data structure to output
 * Decoupled from other classes such as Main or Assigner because file parsing may change with problem definition
 *
 * IOInterface is used to ensure any change of implementation (e.g. a redesign due to changed file parsing)
 * does not change the code in other classes
 */
public class FileProcessor implements FileInterface {


    /**
     * @param filePath input filepath which will be read
     * @return String data read from file
     */
    @Override
    public String readAndParseToArrangement(String filePath) throws FileNotFoundException {
        File inputFile = new File(filePath);
        Scanner fileScanner = new Scanner(inputFile);

        StringBuilder text = new StringBuilder();
        while (fileScanner.hasNextLine()) {
            text.append(fileScanner.nextLine()).append("\n");
        }

        fileScanner.close();

        return text.toString();
    }

    /**
     * @param writeData data to be written to file
     * @param filePath  path to where the data will be written
     */
    @Override
    public void writeArrangementToPath(String writeData, String filePath) throws IOException {
        File out = new File(filePath);
        FileWriter writer = new FileWriter(out);

        Scanner dataReader = new Scanner(writeData);
        StringBuilder output = new StringBuilder();
        while (dataReader.hasNextLine()) {
            output.append(dataReader.nextLine()).append("\n");
        }
        writer.write(output.toString());

        dataReader.close();
        writer.close();
    }
}
