import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SeatArrangementArrayTest {

    public SeatArrangementArrayTest() {

    }

    @Test
    public void seatArrangementTest() {
        SeatArrangementArray arrangement = new SeatArrangementArray(5, 5);
        arrangement.setSeatStatus(0, 0, "hi");
        assertEquals(arrangement.getSeatStatus(0, 0), "hi");
        assertFalse(arrangement.coordValid(-1, -1));
        assertEquals(arrangement.toString(), """
                hi A1
                """);
    }
}