package lotto.domain.exception;

public final class MoneyLowException extends IllegalArgumentException {

    private static final String BELOW_MIN_MONEY_ERROR_MESSAGE = "최소 1000원 이상이어야 합니다.";

    public MoneyLowException() {
        super(BELOW_MIN_MONEY_ERROR_MESSAGE);
    }

}
