package lotto.model;

import lotto.exception.MinimumAmountException;

import java.util.Objects;

public class Money {

    public static final Money ZERO = Money.won(0);
    private long amount;

    private Money(long amount) {
        this.amount = amount;
    }

    public static Money won(long amount) {
        if (amount < 0) {
            throw new MinimumAmountException(amount);
        }
        return new Money(amount);
    }

    static Money calculateTotal(long count) {
        return Lotto.PRICE.times(count);
    }

    public int countAvailableLotto() {
        return (int) (this.amount / Lotto.PRICE.amount);
    }


    public Money plus(Money money) {
        return new Money(this.amount + money.amount);
    }

    public Money times(long count) {
        return new Money(amount * count);
    }

    public Money subtract(Money money) {
        return new Money(amount - money.amount);
    }

    public double divide(Money money) {
        if (Money.ZERO.amount == money.amount) {
            return 0;
        }
        return (double) this.amount / money.amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return amount == money1.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return String.valueOf(amount);
    }
}