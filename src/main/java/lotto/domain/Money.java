package lotto.domain;

public class Money {

    private static final int LOTTO_PRICE = 1000;
    private int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money < LOTTO_PRICE) {
        throw new IllegalArgumentException("금액이 부족합니다. 로또를 구매할 수 없습니다.");
        }
    }

    public int getMoney() {
        return money;
    }
}
