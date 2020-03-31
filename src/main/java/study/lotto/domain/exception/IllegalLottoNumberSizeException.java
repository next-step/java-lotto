package study.lotto.domain.exception;

public class IllegalLottoNumberSizeException
        extends IllegalArgumentException {
    public IllegalLottoNumberSizeException(String s) {
        super(s);
    }
}
