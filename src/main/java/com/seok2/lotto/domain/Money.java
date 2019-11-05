package com.seok2.lotto.domain;

public class Money {

    private static final String CURRENCY_UNIT = " 원";
    private static final int ZERO_VALUE = 0;
    public static final Money ZERO = new Money(ZERO_VALUE);

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
        if (money.money == ZERO_VALUE) {
            return this;
        }
        return Money.of(this.money - money.money);
    }

    public Money multiply(int value) {
        if (value == ZERO_VALUE) {
            return Money.ZERO;
        }
        return Money.of(money * value);
    }

    public Money add(Money money) {
        if (money.money == ZERO_VALUE) {
            return this;
        }
        return Money.of(this.money + money.money);
    }

    public double percnet(Money money) {
        if (money.money == ZERO_VALUE) {
            return ZERO_VALUE;
        }
        return this.money / (double) money.money;
    }

    @Override
    public String toString() {
        return money + CURRENCY_UNIT;
    }
}
