import java.util.ArrayList;

/**
 * This is implementation provided for assigner abstract class
 * it assigns seats in a "snake-like" pattern, see readme for more details
 */
public class AssignerIterative extends Assigner {

    //padding between seats, by default is 3
    private final int SEAT_SPACING;

    /**
     * @param seatArrangement input seat arrangement to be operated on
     * @param reservation     input reservation object, obtained from parsed text file
     */
    public AssignerIterative(SeatArrangement seatArrangement, Reservation reservation) {
        super(seatArrangement, reservation);
        this.SEAT_SPACING = 3;
    }

    /**
     * method to assign all seats from this.reservation to this.seatArrangement
     */
    @Override
    public void assignSeats() throws SeatsExceededException {

        final SeatArrangement arrangement = super.getSeatArrangement();
        final Reservation reservation = super.getReservation();
        final int nRow = arrangement.getNumRows();
        final int nCol = arrangement.getNumCols();

        final ArrayList<String> identifierList = reservation.getIdentifierList();

        int currRow = 0;
        int currCol = 0;
        int step = 1;

        // when you finish one, you add the extra spaces unless you get to the end of a row
        for (String id : identifierList) {
            int blockSize = reservation.getNumForIdentifier(id);
            if (blockSize <= 0) { continue; }

            boolean addingSpaces = false;
            for (int j = 0; j < blockSize; j++, currCol += step) {

                if (currRow == nRow) {
                    throw new SeatsExceededException("Error: attempted to seat more people than possible");
                }
                //when we reach the end of a row, go down one and change step to move in opposite direction
                if ((currCol == nCol && step == 1) || (currCol == -1 && step == -1)) {
                    currCol--;
                    currRow++;
                    step *= -1;
                }

                arrangement.setSeatStatus(currRow, currCol, id);

            }

            //adding spaces in between sections
            for (int j = 0; j < this.SEAT_SPACING; j++, currCol += step) {
                //if spaces finish off row, don't add any more and just go to the next row
                //because being on a different row counts as valid separation
                if (currCol == nCol) { break; }
            }
        }

    }


}
