package calculator.exception;

public class InvalidOutputIntegerException extends IllegalArgumentException {

    private static final String MESSAGE = "나눗셈 결과 값이 정수가 아닙니다.";

    public InvalidOutputIntegerException() {
        super(MESSAGE);
    }

    public InvalidOutputIntegerException(String message) {
        super(message);
    }
}
