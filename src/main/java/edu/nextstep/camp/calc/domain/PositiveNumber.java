package edu.nextstep.camp.calc.domain;

import java.util.Objects;
import java.util.regex.Pattern;

// Note: 엄밀히 따지면 0을 포함하므로 NonNegativeNumber가 맞지만, 이름이 너무 길고 부정적이라 이렇게 함
// Note: 대안으로는 UnsignedNumber나 AbsoluteNumber도 가능은 하지만, 용도와 맞지 않는다고 판단.
public class PositiveNumber {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");
    private static final String TO_STRING_FORMAT = "Number(%d)";

    public static final PositiveNumber ZERO = new PositiveNumber(0);

    private final int number;

    private PositiveNumber(int number) {
        this.number = number;
    }

    public static PositiveNumber of(int number) {
        if (number < ZERO.number) {
            throw new IllegalArgumentException("invalid input: the number must not be negative: " + number);
        }

        if (number == ZERO.number) {
            return ZERO;
        }

        return new PositiveNumber(number);
    }

    public static PositiveNumber of(String numberString) {
        if (numberString == null || numberString.isEmpty()) {
            return PositiveNumber.ZERO;
        }

        if (!NUMBER_PATTERN.matcher(numberString).matches()) {
            throw new IllegalArgumentException("invalid input(given value is not a number):" + numberString);
        }

        return PositiveNumber.of(Integer.parseInt(numberString));
    }

    public PositiveNumber add(PositiveNumber that) {
        return PositiveNumber.of(number + that.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber that = (PositiveNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public int toInt() {
        return number;
    }

    public String toString() {
        return String.format(TO_STRING_FORMAT, number);
    }
}
