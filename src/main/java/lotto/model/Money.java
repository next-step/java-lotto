package lotto.model;

import lotto.exception.MinimumAmountException;

import java.util.Objects;

public class Money {

    public static final int MIN_NUMBER_OF_BUY_LOTTO = 1;
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

    static Money buyTotalLotto(long count) {
        return Lotto.PRICE.times(count);
    }

    public int countAvailableByLotto() {
        return (int) (this.amount / Lotto.PRICE.amount);
    }


    Money plus(Money money) {
        return new Money(this.amount + money.amount);
    }

    Money times(long count) {
        return new Money(amount * count);
    }

    double divide(Money money) {
        if (Money.ZERO.amount == money.amount) {
            return 0;
        }
        return (double) this.amount / money.amount;
    }

    public Money spendOnLotto(long numberOfLotto) {
        return new Money(amount - Lotto.PRICE.amount * numberOfLotto);
    }

    public boolean hasBuyLotto() {
        return MIN_NUMBER_OF_BUY_LOTTO <= (amount / Lotto.PRICE.amount);
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