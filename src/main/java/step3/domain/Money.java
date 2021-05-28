package step3.domain;

import step3.exception.NotEnoughInitMoneyException;

public class Money {

    private static final int ONE_LOTTO_PRICE = 1000;

    private int money;

    public Money(int money) {
        checkInRange(money);

        this.money = money;
    }

    public void buyOneLotto() {
        this.money -= ONE_LOTTO_PRICE;
    }

    public boolean hasEnoughMoney() {
        return money >= ONE_LOTTO_PRICE;
    }

    private void checkInRange(int money) {
        if (money < ONE_LOTTO_PRICE) {
            throw new NotEnoughInitMoneyException();
        }
    }
}
