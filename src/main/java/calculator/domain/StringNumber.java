package calculator.domain;

import java.util.Objects;

public class StringNumber {

    private static final String WRONG_NUMBER_MESSAGE = "숫자는 0이상의 정수여야 합니다.";
    private static final String CORRECT_INPUT_PATTERN = "[0-9]*";
    private final int number;

    public StringNumber(String number) {
        this.number = validateNumber(number);
    }

    private int validateNumber(String number) {
        if (number == null || number.isBlank() || !number.matches(CORRECT_INPUT_PATTERN)) {
            throw new IllegalArgumentException(WRONG_NUMBER_MESSAGE);
        }

        if (Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException(WRONG_NUMBER_MESSAGE);
        }
        return Integer.parseInt(number);
    }

    public StringNumber calculate(StringOperator operator, StringNumber other) {
        int result = operator.calculate(number, other.number);
        return new StringNumber(Integer.toString(result));
    }

    public int toInt() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringNumber that = (StringNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
