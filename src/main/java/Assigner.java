/**
 * This class is responsible for assignment logic of the seats, concrete version utilizes packing algorithm
 */
public abstract class Assigner {

    private final SeatArrangement seatArrangement;
    private final Reservation reservation;

    /**
     *
     * @param seatArrangement input seat arrangement to be operated on
     * @param reservation input reservation object, obtained from parsed text file
     */
    public Assigner(SeatArrangement seatArrangement, Reservation reservation) {
        this.seatArrangement = seatArrangement;
        this.reservation = reservation;
    }

    /**
     * method to assign all seats from this.reservation to this.seatArrangement
     */
    public abstract void assignSeats() throws SeatsExceededException;

    /**
     * method to get seat arrangement, for concrete children
     * @return seatArrangement instance
     */
    protected SeatArrangement getSeatArrangement() {
        return this.seatArrangement;
    }

    /**
     * method to get reservation instance, for concrete children
     * @return reservation instance
     */
    protected Reservation getReservation() {
        return this.reservation;
    }


}
