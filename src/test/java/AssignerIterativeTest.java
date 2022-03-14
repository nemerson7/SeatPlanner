import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class AssignerIterativeTest {


    public AssignerIterativeTest() {

    }

    @Test
    public void assignerIterative() throws Exception {
        final String IN_PATH = new File("./input-tests/test1.txt").getCanonicalPath();

        FileInterface fileProcessor = new FileProcessor();
        String fileInput = fileProcessor.readAndParseToArrangement(IN_PATH);

        SeatArrangement seatArrangement = new SeatArrangementArray(10, 20);
        Reservation reservation = new ReservationHashMap(fileInput);
        Assigner assigner = new AssignerIterative(seatArrangement, reservation);

        assigner.assignSeats();
        String output = seatArrangement.toString();

        assertEquals("""
                R001 A1,A2
                R002 A6,A7,A8,A9
                R003 A13,A14,A15,A16
                R004 A20,B12,B13,B14,B15,B16,B17,B18,B19,B20
                """, output);


    }

    @Test
    public void assignerIterative1() throws Exception {

        final String IN_PATH = new File("./input-tests/test3.txt").getCanonicalPath();

        FileInterface fileProcessor = new FileProcessor();
        String fileInput = fileProcessor.readAndParseToArrangement(IN_PATH);

        SeatArrangement seatArrangement = new SeatArrangementArray(10, 20);
        Reservation reservation = new ReservationHashMap(fileInput);
        Assigner assigner = new AssignerIterative(seatArrangement, reservation);


        Exception e = assertThrows(Exception.class, assigner::assignSeats);
        String expected = "Error: attempted to seat more people than possible";
        assertTrue(e.getMessage().contains(expected));

    }

}