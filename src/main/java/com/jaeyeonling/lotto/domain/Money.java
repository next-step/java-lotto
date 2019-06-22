package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.config.Env;
import com.jaeyeonling.lotto.exception.LowMoneyException;

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

    boolean isCanBuy(final Dealable item) {
        return false;
    }

    private void spend(final Money price) {
        if (isLowMoney(price)) {
            throw new LowMoneyException(money, price.money);
        }

        money -= price.money;
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

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}
