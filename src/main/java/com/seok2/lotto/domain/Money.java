package com.seok2.lotto.domain;

import java.math.BigDecimal;

public class Money {

    private static final String CURRENCY_UNIT = " 원";
    private static final int ZERO_VALUE = 0;
    private static final Money ZERO = new Money(0);
    private final int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money of(int money) {
        return new Money(money);
    }

    protected boolean moreThanOrEquals(Money money) {
        return this.money >= money.money;
    }

    protected Money minus(Money money) {
        if (money.money == ZERO_VALUE)
            return this;
        return new Money((this.money - money.money));
    }

    public Money clone() {
        return new Money(this.money);
    }

    @Override
    public String toString() {
        return money + CURRENCY_UNIT;
    }

    public Money multiply(int value) {
        if (value == ZERO_VALUE)
            return Money.ZERO;
        return new Money(money * value);
    }

    public Money add(Money money) {
        if (money.money == ZERO_VALUE)
            return this;
        return new Money(this.money + money.money);
    }

    public Profit calculateProfit(Money investment) {
        return new Profit(this.money / (double) investment.money);
    }
}
