package lotto.domain;

import java.util.Objects;

/**
 * 돈
 */
public final class Money implements Comparable<Money> {
    private final int money;

    public Money(final int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    @Override
    public int compareTo(final Money money) {
        return this.money - money.money;
    }
}
