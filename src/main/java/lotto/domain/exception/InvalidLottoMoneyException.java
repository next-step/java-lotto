package lotto.domain.exception;

public class InvalidLottoMoneyException extends LottoException {
    private static final String INVALID_LOTTO_MONEY_MESSAGE = "금액의 범위는 0 이상이어야 합니다.";

    public InvalidLottoMoneyException(String... message) {
        super(INVALID_LOTTO_MONEY_MESSAGE, message);
    }
}
