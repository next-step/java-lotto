package lotto;

import java.util.Objects;
import java.util.regex.Pattern;

public class Number implements Comparable<Number> {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");
    private static final String NOT_VALID_NUMBER_INPUT_MESSAGE = "유효한 숫자 입력이 아닙니다.";

    private final int number;

    public Number(String number) {
        validateNumber(number);
        this.number = Integer.parseInt(number);
    }

    public Number(int number) {
        this.number = number;
    }

    private void validateNumber(String number) {
        if (!NUMBER_PATTERN.matcher(number).matches()) {
            throw new IllegalArgumentException(NOT_VALID_NUMBER_INPUT_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number other = (Number) o;
        return number == other.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(Number o) {
        if (this.number >= o.number) {
            return 1;
        }
        return -1;
    }

}
