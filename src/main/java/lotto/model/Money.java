package lotto.model;

import lotto.exception.MinimumAmountException;

import java.util.Objects;

public class Money {

    private static final int MIN_NUMBER_OF_BUY_LOTTO = 1;
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
        return Math.floor((double) prizeMoney.amount / totalOfBuyLotto.amount) * 100.0;
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

    boolean hasBuyLotto() {
        return MIN_NUMBER_OF_BUY_LOTTO <= (amount / Lotto.PRICE.amount);
    }

    public int countAvailableByLotto() {
        return (int) (this.amount / Lotto.PRICE.amount);
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