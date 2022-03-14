import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Nick Emerson
 *
 * Main class, aggregates SeatArrangement, Reservation, Assigner,
 * and FileInterface objects (along with corresponding implementation classes provided)
 */

public class Main {

    public static void main(String[] args) throws IOException, SeatsExceededException, Exception {

        //change output.txt to preferred name
        final String OUT_PATH = new File("output.txt").getCanonicalPath();
        final int N_ROW = 10;
        final int N_COL = 20;

        Scanner in = new Scanner(System.in);

        FileInterface fileProcessor = new FileProcessor();
        System.out.print("Input file path: ");
        String filePath = in.nextLine().trim();
        in.close();
        String fileInput = fileProcessor.readAndParseToArrangement(filePath);

        SeatArrangement seatArrangement = new SeatArrangementArray(N_ROW, N_COL);
        Reservation reservation = new ReservationHashMap(fileInput);
        Assigner assigner = new AssignerIterative(seatArrangement, reservation);

        assigner.assignSeats();
        String output = seatArrangement.toString();
        //System.out.println("printing output: " + output);
        fileProcessor.writeArrangementToPath(output, OUT_PATH);

        System.out.println(OUT_PATH);

    }
}
