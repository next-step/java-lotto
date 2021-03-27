package step2.domain;

import step2.constants.Constants;

public class Money {
    private int money;

    private Money(final int amount) {
        this.money = amount;
    }

    public static Money from(final int amount) {
        return new Money(amount);
    }

    public void buyLotto() {
        this.money = money - Constants.LOTTO_PRICE;
    }

    public boolean isPossibleBuyLotto() {
        return money >= Constants.LOTTO_PRICE;
    }
}
