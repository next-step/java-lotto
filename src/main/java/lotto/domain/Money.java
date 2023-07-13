package lotto.domain;

import java.util.Objects;

public class Money {

    private final Long value;

    public Money(final Long value) {
        validate(value);
        this.value = value;
    }

    private void validate(final Long value) {
        if (value < 0) {
            throw new IllegalArgumentException("money amount should greater than 0");
        }
    }

    public Double divide(Money divisor) {
        if (divisor.value.equals(0L)) {
            throw new IllegalArgumentException("divisor should be positive number");
        }
        return (double) this.value / divisor.value;
    }

    public boolean isUnderThan(Long other) {
        return this.value < other;
    }

    public int calculateQuantity(final Money price) {
        return (int) (value / price.value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return Objects.equals(value, money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
