package lotto.model;

import lotto.exception.MoneyNumberException;

import java.util.Objects;

public final class Money {

    private static final long MIN_VALUE = 1000L;

    private final long value;

    public Money(long value) {
        validate(value);
        this.value = value;
    }

    private void validate(long value) {
        if (value < MIN_VALUE) {
            throw new MoneyNumberException(value);
        }
    }

    public long currentValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
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
