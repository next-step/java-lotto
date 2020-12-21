package step2.exception;

public class NumberMustBeSixException extends IllegalArgumentException {
    public NumberMustBeSixException(String errorMessage) {
        super(errorMessage);
    }
}
