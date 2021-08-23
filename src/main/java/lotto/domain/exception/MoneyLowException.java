package lotto.domain.exception;

public final class MoneyLowException extends IllegalArgumentException {

    private static final String BELOW_MIN_MONEY_ERROR_MESSAGE = "금액이 음수입니다.";

    public MoneyLowException() {
        super(BELOW_MIN_MONEY_ERROR_MESSAGE);
    }

}
