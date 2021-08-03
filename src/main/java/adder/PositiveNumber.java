package adder;

import java.util.Objects;

import static java.lang.Integer.parseInt;

public class PositiveNumber {

    public static final String NON_NULL = "입력된 문자는 null 일 수 없습니다";
    public static final String NOT_NUMBER = "숫자가 아닙니다 -> ";
    public static final String NEGATIVE_NUMBER = "음수일 수 없습니다 -> ";
    public static final int ZERO_INTEGER = 0;
    public static final PositiveNumber ZERO = new PositiveNumber(ZERO_INTEGER);

    private final int number;

    public PositiveNumber(String number) {
        validateNumber(number);
        this.number = parsePositiveNumber(number);
    }

    public PositiveNumber(int number) {
        this.number = number;
    }

    public int toInt() {
        return number;
    }

    public PositiveNumber sum(PositiveNumber positiveNumber) {
        return new PositiveNumber(number + positiveNumber.number);
    }

    private void validateNumber(String number) {
        requireNonNull(number);
        if (!isBlank(number)) {
            requireNumber(number);
            requirePositiveNumber(number);
        }
    }

    private void requireNonNull(String number) {
        if (Objects.isNull(number)) {
            throw new IllegalArgumentException(NON_NULL);
        }
    }

    private void requireNumber(String number) {
        try {
            parseInt(number);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER + number);
        }
    }

    private void requirePositiveNumber(String number) {
        if (parseInt(number) < ZERO_INTEGER) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER + number);
        }
    }

    private int parsePositiveNumber(String number) {
        return isBlank(number)
                ? ZERO_INTEGER
                : parseInt(number);
    }

    private boolean isBlank(String number) {
        return number.trim()
                .isEmpty();
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
}
