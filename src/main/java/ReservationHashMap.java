import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class is coupled to the input format specified by the problem
 * Its implementation is decoupled from the rest of the program with the Reservation abstract class
 */

public class ReservationHashMap extends Reservation {

    ConcurrentHashMap<String, Integer> map;
    //added to ensure order of input reservations matches
    //order of output reservation to best mimic desired output example
    ArrayList<String> idArrayList;

    public ReservationHashMap(String inputData) throws Exception {
        this.map = new ConcurrentHashMap<>();
        this.idArrayList = new ArrayList<>();

        Scanner dataParser = new Scanner(inputData);
        while (dataParser.hasNextLine()) {
            String line = dataParser.nextLine();
            if (line.equals("")) { continue; }
            String[] split = line.split(" ");
            if (split.length != 2) { throw new Exception("Invalid formatting of input file"); }
            String identifier = split[0];
            int quantity = Integer.parseInt(split[1]);
            this.map.put(identifier, quantity);
            this.idArrayList.add(identifier);
        }
        dataParser.close();

        //throwing error if input data could not be read
        if (this.idArrayList.size() == 0) throw new Exception("No input data could be obtained");
        //throwing error if an identifier is repeated
        if (this.idArrayList.size() != this.map.keySet().size()) throw new Exception("Repeated identifiers in input file");

    }

    /**
     * @param identifier identifier to query to get seat order quantity
     * @return seat order quantity, non-negative integer
     */
    @Override
    public int getNumForIdentifier(String identifier) {
        return this.map.get(identifier);
    }

    /**
     * Provides an arraylist of the identifiers stored by the Reservation
     *
     * @return arraylist of String identifiers user by the reservation
     */
    @Override
    public ArrayList<String> getIdentifierList() {
        return this.idArrayList;
    }
}
