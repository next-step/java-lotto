package lotto.domain;

import lotto.exception.OutOfRangeException;

import java.util.Objects;

public final class LottoNumber extends Number implements Comparable<LottoNumber> {
    private final Number value;

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    public LottoNumber(Number value) {
        this.value = value;

        validNumber();
    }

    private void validNumber() {
        int value = intValue();
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new OutOfRangeException();
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
    public boolean equals(Object compareValue) {
        if (!(compareValue instanceof Number))
            return false;
        Number that = (Number) compareValue;
        return intValue() == that.intValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int compareTo(LottoNumber compareValue) {
        return Integer.compare(intValue(), compareValue.intValue());
    }
}
