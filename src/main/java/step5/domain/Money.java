package step5.domain;

import step5.exception.NotEnoughInitMoneyException;

public class Money {

    private static final int ONE_LOTTO_PRICE = 1000;

    private int amount;

    public Money(int amount) {
        checkInRange(amount);

        this.amount = amount;
    }

    public void buyOneLotto() {
        this.amount -= ONE_LOTTO_PRICE;
    }

    public boolean canBuyAutoLotto() {
        return amount >= ONE_LOTTO_PRICE;
    }

    private void checkInRange(int money) {
        if (money < ONE_LOTTO_PRICE) {
            throw new NotEnoughInitMoneyException();
        }
    }

    public int getCurrentMoney() {
        return this.amount;
    }

    public void minus(Money amount) {
        this.amount -= amount.getCurrentMoney();
    }
}
