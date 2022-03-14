/**
 * Abstract class for seat arrangement
 * provides interface in case implementation (e.g. SeatArrangementArray) changes
 * SeatArrangementArray is more closely coupled to project specifics
 */
public abstract class SeatArrangement {

    private int nRow;
    private int nCol;

    public SeatArrangement(int nRow, int nCol) {
        this.nRow = nRow;
        this.nCol = nCol;
    }

    /**
     *
     * @param row input row
     * @param col input column
     * @return String identifier for reservation of seat, else null if no reservation established yet
     */
    public abstract String getSeatStatus(int row, int col);

    /**
     *
     * @param row input row
     * @param col input col
     * @param value val to be place at row, col location
     * @return true if assignment is successful, false if otherwise
     */
    public abstract boolean setSeatStatus(int row, int col, String value);

    /**
     * Converts arrangement to desired output.
     * For this project, concrete SeatArrangementArray class is
     * coupled to desired project output format for file
     * @return string representation of arrangement
     */
    public abstract String toString();

    /**
     *
     * @return total number of rows in theater
     */
    public int getNumRows() {
        return this.nRow;
    }

    /**
     *
     * @return total number of columns in theater
     */
    public int getNumCols() {
        return this.nCol;
    }

    public boolean coordValid(int row, int col) {
        return row >= 0 && row < this.nRow && col >= 0 && col < this.nCol;
    }

}
