package step2.exception;

public class NotEnoughMoney extends IllegalArgumentException {
    private static final String NOT_ENOUGH_MONEY = "로또를 구매할 금액이 부족합니다.";

    public NotEnoughMoney() {
        super(NOT_ENOUGH_MONEY);
    }
}
