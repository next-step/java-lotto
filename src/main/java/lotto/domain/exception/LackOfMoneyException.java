package lotto.domain.exception;

public class LackOfMoneyException extends IllegalArgumentException {

    private static final String LACK_OF_MONEY_ERROR_MESSAGE = "잔액이 부족합니다.";

    public LackOfMoneyException() {
        super(LACK_OF_MONEY_ERROR_MESSAGE);
    }

}
