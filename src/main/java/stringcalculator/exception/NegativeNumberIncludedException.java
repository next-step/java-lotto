package stringcalculator.exception;

public class NegativeNumberIncludedException extends RuntimeException {
    public NegativeNumberIncludedException(String message) {
        super(message);
    }
}
