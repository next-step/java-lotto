package calculator.exception;

public class InvalidInputException extends IllegalArgumentException {

    private static final String MESSAGE = "입력값이 비어있습니다.";

    public InvalidInputException() {
        super(MESSAGE);
    }

    public InvalidInputException(String message) {
        super(message);
    }
}
