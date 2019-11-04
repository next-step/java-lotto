package com.seok2.lotto.domain;

public class Money {

    private final int money;

    private Money(int money) {
        this.money = money;
    }

    protected static Money of(int money) {
        return new Money(money);
    }

    protected boolean moreThanOrEquals(Money money) {
        return this.money >= money.money;
    }

    protected Money minus(Money money) {
        if (money.money == 0)
            return this;
        return new Money((this.money - money.money));
    }
}
