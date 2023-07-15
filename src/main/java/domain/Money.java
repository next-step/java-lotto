package domain;

import java.util.Objects;

public class Money {

    private static final Money ZERO = new Money(0L);

    private final long value;

    public Money(final long value) {
        validateNonNegative(value);
        this.value = value;
    }

    public static Money createZero() {
        return ZERO;
    }

    public static RateOfReturn calculateRateOfReturn(final Money earned, final Money spent) {
        return new RateOfReturn(earned.value, spent.value);
    }

    public boolean isMultipleOf(final Money other) {
        if (other.isZero()) {
            return false;
        }
        return value % other.value == 0;
    }

    public Count calculateMaximumCount(final Money price) {
        if (price.isZero()) {
            throw new IllegalArgumentException("가격은 0일 수 없습니다.");
        }
        return new Count(value / price.value);
    }

    public Money sum(final Money other) {
        return new Money(value + other.value);
    }

    public Money multiplyByCount(Count count) {
        return new Money(value * count.getValue());
    }

    public boolean isLessThan(final Money other) {
        return value < other.value;
    }

    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private boolean isZero() {
        return value == 0;
    }

    private void validateNonNegative(final long value) {
        if (value < 0) {
            throw new IllegalArgumentException("금액은 음수일 수 없습니다.");
        }
    }
}
