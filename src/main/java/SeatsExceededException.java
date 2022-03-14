/**
 * Esception for when there are more seats allocated on reservation than available
 */
public class SeatsExceededException extends Exception {


    public SeatsExceededException(String message) {
        super(message);
    }

    public SeatsExceededException() {
        super();
    }
}
