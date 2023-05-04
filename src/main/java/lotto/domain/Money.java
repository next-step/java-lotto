package lotto.domain;

import java.util.Objects;

public class Money {
    private long money;

    public Money(long money) {
        this.money = money;
    }
    public Money add(Money other) {
        return new Money(money + other.money);
    }

    public double divide(Money other) {
        return (double) money / other.money;
    }

    public Money multiply(long number) {
        return new Money(money * number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
