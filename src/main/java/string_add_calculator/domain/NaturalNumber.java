package string_add_calculator.domain;

import util.StringUtils;

import java.util.Objects;

public class NaturalNumber {
    public static final int ZERO_VALUE = 0;
    public static final NaturalNumber ZERO = new NaturalNumber(ZERO_VALUE);
    private final int number;

    private NaturalNumber(String numberString) {
        validate(numberString);
        this.number = Integer.parseInt(numberString);
    }

    private NaturalNumber(int number) {
        validate(String.valueOf(number));
        this.number = number;
    }

    private void validate(String numberString) {
        if (!StringUtils.isNaturalNumber(numberString)) {
            throw new RuntimeException("Input string is not natural number " + numberString);
        }
    }

    public static NaturalNumber from(String numberString) {
        return new NaturalNumber(numberString);
    }

    public int toInt() {
        return number;
    }

    public NaturalNumber add(NaturalNumber anotherNaturalNumber) {
        return new NaturalNumber(this.number + anotherNaturalNumber.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NaturalNumber that = (NaturalNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
