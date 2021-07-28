package lotto.domain;

import lotto.exception.OutOfRangeException;

import java.util.Objects;

public final class Money extends Number {
    private final int value;

    private static final int MIN_VALUE = 0;

    public Money(int value) {
        this.value = value;

        validNumber();
    }

    public Money division(Money money) {
        return new Money(this.value / money.value);
    }

    public static Money empty() {
        return InnerClazz.EMPTY;
    }

    private void validNumber() {
        if (value < MIN_VALUE) {
            throw new OutOfRangeException("돈은 음수일 수 없습니다.");
        }
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return intValue();
    }

    @Override
    public float floatValue() {
        return intValue();
    }

    @Override
    public double doubleValue() {
        return intValue();
    }

    @Override
    public boolean equals(Object compareValue) {
        if (this == compareValue) return true;
        if (compareValue == null || getClass() != compareValue.getClass()) return false;
        Money money = (Money) compareValue;
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

    private static class InnerClazz {
        private static Money EMPTY = new Money(MIN_VALUE);
    }
}
