package com.jaeyeonling.lotto.domain;

import java.util.Objects;

public class Money {

    private int money;

    Money(final int money) {
        this.money = money;
    }

    Money getBalance() {
        return new Money(money);
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
