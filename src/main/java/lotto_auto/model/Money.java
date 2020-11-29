package lotto_auto.model;

import lotto_auto.ErrorMessage;

public class Money {

    private final int money;

    public Money(int money) {
        throwIfNegativeMoney(money);
        this.money = money;
    }

    private void throwIfNegativeMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_MONEY);
        }
    }

    public int getMoney() {
        return money;
    }
}
