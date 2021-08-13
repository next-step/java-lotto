package lotto.exception;


public class InvalidManualLottoCountException extends IllegalArgumentException {
    private static final String MESSAGE = "수동 로또 구입 금액이 총 금액보다 많습니다.";

    public InvalidManualLottoCountException() {
        super(MESSAGE);
    }
}

