package lotto.exception;

public class LottoNumberSizeException extends RuntimeException {
    private static final String NUMBER_OUT_OF_RANGE = "숫자 범위 초과";
    public LottoNumberSizeException() {
        super(NUMBER_OUT_OF_RANGE);
    }
}
