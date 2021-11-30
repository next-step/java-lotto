package lotto.exception;

public class InvalidValueException extends RuntimeException {
    private static final String INVALID_VALUE_EXCEPTION_MESSAGE = "숫자이외는 입력하실 수 없습니다.";

    public InvalidValueException() {
        super(INVALID_VALUE_EXCEPTION_MESSAGE);
    }
}
