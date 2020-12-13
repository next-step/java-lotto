package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {

    private static final BigDecimal MIN_VALUE = BigDecimal.ZERO;

    private static final int PROFIT_RATE_SCALE = 2;

    private final BigDecimal amount;

    private Money(final BigDecimal amount) {
        this.amount = amount;
    }

    public static Money valueOf(final long value) {
        return valueOf(BigDecimal.valueOf(value));
    }

    public static Money valueOf(final BigDecimal value) {
        if (value.compareTo(MIN_VALUE) < 0) {
            throw new IllegalArgumentException(String.format("돈은 %s원 미만일 수 없습니다. (입력: %s)", MIN_VALUE, value));
        }
        return new Money(value);
    }

    public static Money zero() {
        return valueOf(MIN_VALUE);
    }

    public Money plus(final Money other) {
        return valueOf(amount.add(other.amount));
    }

    public int divide(final Money other) {
        return amount.divide(other.amount, RoundingMode.DOWN)
                .intValue();
    }

    public Money multiply(final int value) {
        return multiply(BigDecimal.valueOf(value));
    }

    public Money multiply(final BigDecimal count) {
        return valueOf(amount.multiply(count));
    }

    public boolean isLessThen(final Money other) {
        return amount.compareTo(other.amount) < 0;
    }

    public double profitRate(final Money other) {
        return this.amount.divide(other.amount, PROFIT_RATE_SCALE, RoundingMode.DOWN)
                .doubleValue();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        final Money money = (Money) o;
        return Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return amount.toString();
    }
}
