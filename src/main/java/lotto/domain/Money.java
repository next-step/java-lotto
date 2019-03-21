package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    public static final Money ZERO = new Money(0);
    public static final Money ONE = new Money(1);

    private static final int MINIMUM = 0;
    private static final int SCALE = 2;

    private long value;

    private Money(final long value) {
        validate(value);
        this.value = value;
    }

    public static Money from(final long value) {
        return new Money(value);
    }

    public long get() {
        return value;
    }

    public Money multiply(final long multiplicand) {
        return new Money(
                BigDecimal.valueOf(this.value)
                        .multiply(BigDecimal.valueOf(multiplicand))
                        .longValue()
        );
    }

    public double divide(final Money money) {
        return BigDecimal.valueOf(this.value)
                .divide(BigDecimal.valueOf(money.value), SCALE, RoundingMode.FLOOR)
                .doubleValue()
                ;
    }

    private void validate(final long value) {
        if (value < MINIMUM) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
