package exception;

public class NumberNotInRangeException extends RuntimeException {
    public NumberNotInRangeException() {
    }

    public NumberNotInRangeException(String message) {
        super(message);
    }
}
