import java.util.ArrayList;

/**
 * Abstract class for reservation, provides interface for any future change of implementation
 */
public abstract class Reservation {


    /**
     *
     * @param identifier identifier to query to get seat order quantity
     * @return seat order quantity, non-negative integer
     */
    public abstract int getNumForIdentifier(String identifier);

    /**
     * Provides an arraylist of the identifiers stored by the Reservation
     * @return arraylist of String identifiers user by the reservation
     */
    public abstract ArrayList<String> getIdentifierList();

}
