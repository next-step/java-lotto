package com.seok2.lotto.domain;


import java.util.Objects;

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

    public Money add(Money money) {
        if (money.money == ZERO_VALUE) {
            return this;
        }
        return Money.of(this.money + money.money);
    }

    public double percent(Money money) {
        if (money.money == ZERO_VALUE) {
            return ZERO_VALUE;
        }
        return this.money / (double) money.money;
    }

    @Override
    public String toString() {
        return money + CURRENCY_UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
