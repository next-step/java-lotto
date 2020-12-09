package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {

    private static final BigDecimal MIN_VALUE = BigDecimal.ZERO;

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

    public long divide(final Money other) {
        return amount.divide(other.amount, RoundingMode.DOWN)
                .longValue();
    }

    public double profitRate(final Money other) {
        return this.amount.divide(other.amount, 2, RoundingMode.DOWN)
                .doubleValue();
    }

    public Money multiply(final int value) {
        return multiply(BigDecimal.valueOf(value));
    }

    public Money multiply(final BigDecimal count) {
        return valueOf(amount.multiply(count));
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
}
