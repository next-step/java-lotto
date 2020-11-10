package lotto.domain.exception;

public class ManualLottoCountOverMoneyException extends RuntimeException {
    private static final String MESSAGE = "수동 구매 로또수가 구입금액을 초과합니다.";

    public ManualLottoCountOverMoneyException() {
        super(MESSAGE);
    }
}
