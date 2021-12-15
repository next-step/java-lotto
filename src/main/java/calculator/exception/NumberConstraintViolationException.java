package calculator.exception;

public class NumberConstraintViolationException extends IllegalArgumentException {
    public NumberConstraintViolationException() {
        super();
    }

    public NumberConstraintViolationException(String message) {
        super(message);
    }
}
