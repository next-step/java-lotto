package lotto;

public class Money {

    public static final String NOT_ENOUGH_MONEY_ERROR = "금액이 부족합니다. 로또를 구매할 수 없습니다.";
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY_ERROR);
        }
    }

    public int getMoney() {
        return money;
    }
}
