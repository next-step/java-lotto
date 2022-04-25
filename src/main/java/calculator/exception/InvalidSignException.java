package calculator.exception;

public class InvalidSignException extends IllegalArgumentException {

    private static final String MESSAGE = "사칙연산 기호는 +, -, /, * 만 입력이 가능합니다.";

    public InvalidSignException() {
        super(MESSAGE);
    }

    public InvalidSignException(String message) {
        super(message);
    }
}
