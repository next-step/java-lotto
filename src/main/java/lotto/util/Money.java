package lotto.util;

import lotto.exception.OutOfRangeException;

import java.util.List;
import java.util.Objects;

public final class Money extends Number {
    private final long value;

    private static final int MIN_VALUE = 0;

    public Money(long value) {
        this.value = value;

        validNumber();
    }

    public static Money sum(List<Money> moneyList) {
        return new Money(moneyList.stream().mapToInt(
                iMoney -> iMoney.intValue()
        ).sum());
    }

    public Money addition(Number number) {
        return addition(number.longValue());
    }

    public Money addition(long number) {
        return new Money(this.value + number);
    }

    public Money division(Number number) {
        return division(number.longValue());
    }

    public Money division(long number) {
        return new Money(this.value / number);
    }

    public Money multiply(Number number) {
        return multiply(number.longValue());
    }

    public Money multiply(long number) {
        return new Money(this.value * number);
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
        return (int) value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        throw new ClassCastException("float 타입이 아닙니다.");
    }

    @Override
    public double doubleValue() {
        throw new ClassCastException("double 타입이 아닙니다.");
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
