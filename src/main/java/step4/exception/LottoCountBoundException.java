package step4.exception;

public class LottoCountBoundException extends IllegalArgumentException {

    private static final String LOTTO_COUNT_BOUND_EXCEPTION = "로또 만들때 갯수는 6개여야 합니다.";

    public LottoCountBoundException() {
        super(LOTTO_COUNT_BOUND_EXCEPTION);
    }
}
