package step2.exception;

public class NotEnoughMoneyException extends IllegalArgumentException {
    private static final String NOT_ENOUGH_MONEY = "로또를 구매할 금액이 부족합니다.";

    public NotEnoughMoneyException() {
        super(NOT_ENOUGH_MONEY);
    }
}
