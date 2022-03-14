import java.util.ArrayList;
import java.util.HashMap;

/**
 * Implementation of SeatArrangement abstract class
 * toString method is used to process seat assignments into desired string output
 */
public class SeatArrangementArray extends SeatArrangement {

    private final String[][] internalArray;

    public SeatArrangementArray(int nRow, int nCol) {
        super(nRow, nCol);
        this.internalArray = new String[nRow][nCol];
    }

    /**
     * @param row input row
     * @param col input column
     * @return String identifier for reservation of seat, else null if no reservation established yet
     */
    @Override
    public String getSeatStatus(int row, int col) {
        if (!super.coordValid(row, col)) { return null; }
        return this.internalArray[row][col];
    }

    /**
     * @param row input row
     * @param col input col
     * @param value val to be place at row, col location
     * @return true if assignment is successful, false if otherwise
     */
    @Override
    public boolean setSeatStatus(int row, int col, String value) {
        if (!super.coordValid(row, col) || (this.getSeatStatus(row, col) != null)) { return false; }
        this.internalArray[row][col] = value;
        return true;
    }

    /**
     * Converts arrangement to desired output.
     * For this project, concrete SeatArrangementArray class is
     * coupled to desired project output format for file
     *
     * @return string representation of arrangement
     */
    @Override
    public String toString() {

        //parallel list structure used to ensure order is preserved
        //HashMap used to map identifier to index in both arrays and give us constant access time
        ArrayList<String> identifiers = new ArrayList<>();
        ArrayList<ArrayList<String>> seatCoords = new ArrayList<>();
        HashMap<String, Integer> identifierToIndex = new HashMap<>();

        for (int i = 0; i < this.internalArray.length; i++) {
            for (int j = 0; j < this.internalArray[0].length; j++) {
                String val = this.internalArray[i][j];
                if (val == null) { continue; }

                if (identifierToIndex.containsKey(val)) {
                    int idx = identifierToIndex.get(val);
                    String coordStr = this.coordToSeatNumber(i, j);
                    seatCoords.get(idx).add(coordStr);
                } else {
                    identifierToIndex.put(val, seatCoords.size());
                    identifiers.add(val);
                    ArrayList<String> newList = new ArrayList<>();
                    newList.add(this.coordToSeatNumber(i, j));
                    seatCoords.add(newList);
                }
            }
        }

        //now we iterate over parallel structures, construct output

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < identifiers.size(); i++) {
            output.append(identifiers.get(i)).append(" ");
            ArrayList<String> seats = seatCoords.get(i);
            for (int j = 0; j < seats.size(); j++) {
                output.append(seats.get(j)).append((j < seats.size() - 1) ? "," : "\n");
            }
        }

        return output.toString();

    }

    /**
     * method to convert array row and col indices into desired seat number format
     * @param row seat row
     * @param col seat column
     * @return string representing ticked location in seat arrangement
     */
    public String coordToSeatNumber(int row, int col) {
        return String.valueOf((char) (65 + row)) + String.valueOf(col + 1);
    }
}
