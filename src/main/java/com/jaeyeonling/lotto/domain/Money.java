package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.exception.LowMoneyException;

import java.util.Objects;

public class Money {

    private static final int DEFAULT_AMOUNT_OF_ITEM = 1;
    private static final int MINIMUM = 0;

    private long money;

    public Money() {
        this(MINIMUM);
    }

    public Money(final long money) {
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    public void buy(final Dealable item) {
        spend(item.getPrice());
    }

    public boolean canBuy(final Money price) {
        return canBuy(price, DEFAULT_AMOUNT_OF_ITEM);
    }

    public boolean canBuy(final Money price,
                          final int amount) {
        return this.money - price.money * amount >= MINIMUM;
    }

    private void spend(final Money price) {
        if (!canBuy(price)) {
            throw new LowMoneyException(money, price.money);
        }

        money -= price.money;
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
