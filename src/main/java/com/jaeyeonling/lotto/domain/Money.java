package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.config.Env;

import java.util.Objects;

public class Money {

    private int money;

    Money() {
        this(Env.MINIMUM_MONEY);
    }

    Money(final int money) {
        this.money = money;
    }

    void buy(final Dealable item) {
        spend(item.getPrice());
    }

    private void spend(final Money price) {
        if (isLowMoney(price)) {
            throw new ArithmeticException();
        }
        this.money -= price.money;
    }

    private boolean isLowMoney(final Money price) {
        return this.money - price.money < Env.MINIMUM_MONEY;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Money)) {
            return false;
        }

        final Money money = (Money) o;
        return this.money == money.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
