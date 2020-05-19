package number;

import exception.NegativeNumberException;
import util.StringUtil;

import java.util.Objects;

public class Number {

    public static final Number ZERO = new Number(Number.ZERO_VALUE);
    public static final int ZERO_VALUE = 0;

    private int value;

    private Number() {
    }

    private Number(final int number) {
        validateNegativeNumber(number);
        this.value = number;
    }

    private Number(final String number) throws NumberFormatException {
        this.value = StringUtil.toInt(number);
        validateNegativeNumber(this.value);
    }

    public static Number of(final String number) {
        return new Number(number);
    }

    private void validateNegativeNumber(final int number) {
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
