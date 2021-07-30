package lotto.domain;

import lotto.exception.OutOfRangeException;

import java.util.Objects;

public final class Money extends Number {
    private static final int MIN_VALUE = 0;

    private final Number value;

    public Money(Number value) {
        validateNumber(value);

        this.value = value;
    }

    private void validateNumber(Number value) {
        if (value.longValue() < MIN_VALUE) {
            throw new OutOfRangeException("돈은 음수일 수 없습니다.");
        }
    }

    @Override
    public int intValue() {
        return value.intValue();
    }

    @Override
    public long longValue() {
        return value.longValue();
    }

    @Override
    public float floatValue() {
        return value.floatValue();
    }

    @Override
    public double doubleValue() {
        return value.doubleValue();
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object compareValue) {
        if (!(compareValue instanceof Number)) {
            return false;
        }
        Number thar = (Number) compareValue;
        return value.longValue() == thar.longValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
