package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money implements Comparable<Money> {
    public static final Money ZERO = new Money(BigDecimal.ZERO);
    public static final Money ONE = new Money(BigDecimal.ONE);

    private static final int DEFAULT_SCALE = 0;
    private static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.FLOOR;

    private BigDecimal value;

    private Money(final BigDecimal value) {
        validate(value);
        this.value = value;
    }

    public static Money from(final long value) {
        return new Money(BigDecimal.valueOf(value));
    }

    public Money add(final Money money) {
        return new Money(this.value.add(money.value));
    }

    public Money subtract(final Money money) {
        return new Money(this.value.subtract(money.value));
    }

    public Money multiply(final long multiplicand) {
        return new Money(this.value.multiply(BigDecimal.valueOf(multiplicand)));
    }

    public BigDecimal divide(final Money money) {
        return divide(money, DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
    }

    public BigDecimal divide(final Money money, final int scale) {
        return divide(money, scale, DEFAULT_ROUNDING_MODE);
    }

    public BigDecimal divide(final Money money, final int scale, final RoundingMode roundingMode) {
        return this.value.divide(money.value, scale, roundingMode);
    }

    private void validate(final BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int compareTo(final Money o) {
        return this.value.compareTo(o.value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Money money = (Money) o;
        return Objects.equals(value, money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
