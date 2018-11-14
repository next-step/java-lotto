package lotto.exceptions;

public class ValidationException extends RuntimeException {

    private static final String VALIDATION_WARNING = "you can buy lotto in your budget";

    public ValidationException() {
        super(VALIDATION_WARNING);
    }
}
