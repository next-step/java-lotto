package exception;

public class NumberNotInRangeException extends Exception {
    public NumberNotInRangeException() {
    }

    public NumberNotInRangeException(String message) {
        super(message);
    }
}
