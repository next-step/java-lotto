package lotto.model;

import java.util.Objects;

public class Money {
    private final int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public double divide(Money divisor) {
        return (double) amount / divisor.amount;
    }

    public Money add(Money other) {
        return new Money(amount + other.amount);
    }

    public Money multiply(int times) {
        return new Money(amount * times);
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
