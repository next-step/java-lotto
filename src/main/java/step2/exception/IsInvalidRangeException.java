package step2.exception;

public class IsInvalidRangeException extends NumberFormatException {
    public IsInvalidRangeException(String errorMessage) {
        super(errorMessage);
    }
}
