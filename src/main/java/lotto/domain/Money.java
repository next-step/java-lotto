package lotto.domain;

import java.util.Objects;

import static util.Preconditions.checkArgument;

public class Money {
    public static final String MONEY_MUST_NOT_BE_NEGATIVE = "money must not be negative";
    public static final String MONEY_MUST_BE_DIVIDED = "money must be divided";
    public static final Money ZERO = of(0);
    private final long value;

    private Money(final long money) {
        this.value = money;
    }

    public static Money of(long money) {
        checkArgument(money >= 0, MONEY_MUST_NOT_BE_NEGATIVE);
        return new Money(money);
    }

    public long divideWithoutRemainder(final Money money) {
        checkArgument(isDivided(money), MONEY_MUST_BE_DIVIDED);
        return value / money.value;
    }

    public double divide(final Money money) {
        if (money.value == 0) {
            return 0;
        }
        return (double) value / money.value;
    }

    public Money multiply(final int x) {
        return of(value * x);
    }

    public Money plus(final Money money) {
        return of(value + money.value);
    }

    private boolean isDivided(final Money money) {
        return value % money.value == 0;
    }

    public boolean isNotZero() {
        return !isZero();
    }
    
    public boolean isZero() {
        return value == 0;
    }

    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
