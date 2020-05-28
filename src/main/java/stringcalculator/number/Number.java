package stringcalculator.number;

import stringcalculator.exception.NegativeNumberException;
import stringcalculator.util.StringUtil;

import java.util.Objects;

public class Number {

    public static final Number ZERO = new Number(Number.ZERO_VALUE);
    public static final int ZERO_VALUE = 0;

    private int value;

    private Number() {
    }

    private Number(final int number) {
        verifyNegativeNumber(number);
        this.value = number;
    }

    public static Number of(final String number) {
        int parsedInt = StringUtil.toInt(number);
        return new Number(parsedInt);
    }

    private void verifyNegativeNumber(final int number) {
        if (isNegative(number)) {
            throw new NegativeNumberException(number);
        }
    }

    private boolean isNegative(final int number) {
        return number < ZERO_VALUE;
    }

    public Number plus(final Number number) {
        return new Number(this.value + number.value);
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
