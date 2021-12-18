package step2.exception;

public class NotEnoughMoneyException extends IllegalArgumentException {
    private static final String NOT_ENOUGH_MONEY = "금액이 부족합니다. 현재 금액 : %d";

    public NotEnoughMoneyException(long amount) {
        super(String.format(NOT_ENOUGH_MONEY, amount));
    }
}
