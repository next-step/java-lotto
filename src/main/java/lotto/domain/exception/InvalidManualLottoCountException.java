package lotto.domain.exception;

public class InvalidManualLottoCountException extends RuntimeException {
    private static final String MESSAGE = "수동으로 구매할 로또 수는 0 이상이어야 합니다.";

    public InvalidManualLottoCountException() {
        super(MESSAGE);
    }
}
