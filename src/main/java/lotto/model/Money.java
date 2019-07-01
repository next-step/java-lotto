package lotto.model;

import lotto.exception.MinimumAmountException;

import java.util.Objects;

public class Money {

    static final Money ZERO = Money.won(0);

    private final long amount;

    private Money(long amount) {
        this.amount = amount;
    }

    public static Money won(long amount) {
        if (amount < 0) {
            throw new MinimumAmountException(amount);
        }
        return new Money(amount);
    }

    static double getRateOfReturn(Money prizeMoney, Money totalOfBuyLotto) {
        return (double) prizeMoney.amount / totalOfBuyLotto.amount;
    }

    Money sum(Money money) {
        return new Money(this.amount + money.amount);
    }

    Money times(long count) {
        return new Money(amount * count);
    }

    Money spendOnLotto(long numberOfLotto) {
        return Money.won(amount - Lotto.PRICE.amount * numberOfLotto);
    }

    long divide(Money money) {
        return this.amount / money.amount;
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