package stringcalculator.exception;

public class DividedByZeroException extends RuntimeException {

    private static final String DIVIDE_BY_ZERO_ERROR_MESSAGE = "0으로 나눌 수 없습니다.";

    public DividedByZeroException() {
        super(DIVIDE_BY_ZERO_ERROR_MESSAGE);
    }
}
