package calculator.exception;

public class InvalidValueException extends IllegalArgumentException {
    private static final String MESSAGE = "사칙연산자, 공백, 숫자만 사용 가능합니다.";

    public InvalidValueException() {
        super(MESSAGE);
    }
}
