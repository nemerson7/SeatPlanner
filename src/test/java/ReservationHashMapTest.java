import org.junit.Test;

import static org.junit.Assert.*;

public class ReservationHashMapTest {


    private final String INPUT1 = """
                R001 2
                R002 4
                R003 4
                R004 10
                """;
    private final String INPUT2 = "";

    private final String INPUT3 = """
                R001 2
                R002 4
                R003 4
                R003 10
                """;

    private final String INPUT4 = """
                R001 2
                R002
                R003 4
                R003 10
                """;

    public ReservationHashMapTest() {

    }

    @Test
    public void testConstructorParse() throws Exception {
        ReservationHashMap reservation1 = new ReservationHashMap(INPUT1);
        assertEquals(reservation1.getNumForIdentifier("R001"), 2);
        assertEquals(reservation1.getNumForIdentifier("R002"), 4);
        assertEquals(reservation1.getNumForIdentifier("R003"), 4);
        assertEquals(reservation1.getNumForIdentifier("R004"), 10);


        Exception e = assertThrows(Exception.class, () -> { new ReservationHashMap(INPUT2); });
        String expected = "No input data could be obtained";
        assertTrue(e.getMessage().contains(expected));
    }

    @Test
    public void testConstructorParse2() throws Exception {

        Exception e = assertThrows(Exception.class, () -> { new ReservationHashMap(INPUT3); });
        String expected = "Repeated identifiers in input file";
        assertTrue(e.getMessage().contains(expected));
    }

    @Test
    public void testConstructorParse3() throws Exception {

        Exception e = assertThrows(Exception.class, () -> { new ReservationHashMap(INPUT4); });
        String expected = "Invalid formatting of input file";
        assertTrue(e.getMessage().contains(expected));
    }
}