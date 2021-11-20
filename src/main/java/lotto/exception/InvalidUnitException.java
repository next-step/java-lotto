package lotto.exception;

public class InvalidUnitException extends RuntimeException {
    private static final String INVALID_UNIT_EXCEPTION_MESSAGE = "금액단위가 잘못되었습니다.";

    public InvalidUnitException() {
        super(INVALID_UNIT_EXCEPTION_MESSAGE);
    }
}
