package lotto.exception;

public class NumberRangeExceededException extends RuntimeException {
    private static final String NUMBER_OUT_OF_RANGE = "숫자 범위 초과";

    public NumberRangeExceededException() {
        super(NUMBER_OUT_OF_RANGE);
    }
}
