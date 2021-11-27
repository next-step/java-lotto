package lotto.exception;

public class ManualLottoCountException extends RuntimeException {
    private static final String MESSAGE = "구입 금액보다 많이 구매(%d)할수 없습니다.";

    public ManualLottoCountException(int count) {
        super(String.format(MESSAGE, count));
    }
}
