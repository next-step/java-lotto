package lotto.model.domain;

import java.util.Objects;

public final class Money implements Comparable<Money> {

    private final long value;

    private Money(final long value) {
        this.value = value;
    }

    public static Money valueOf(final long value) {
        return new Money(value);
    }

    public long getValue() {
        return value;
    }

    public long quotient(final long divisor) {
        return value / divisor;
    }

    public double divide(final Money divisor) {
        return value / (double) divisor.value;
    }

    public Money remainder(final long divisor) {
        return new Money(value % divisor);
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
    public int compareTo(final Money o) {
        return Long.compare(value, o.value);
    }
}
