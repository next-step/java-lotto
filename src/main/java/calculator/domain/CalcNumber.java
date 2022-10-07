package calculator.domain;

import java.util.Objects;

public class CalcNumber {
    private static final String INPUT_INTEGER = "정수를 입력해주세요. : ";
    private static final String NULL_OR_BLANK_INPUT_ERROR_MESSAGE = "입력값이 NULL 이거나 빈공백으로 입력되었습니다.";

    private final int number;

    public CalcNumber(final String number) {
        this(toInt(number));
    }

    public CalcNumber(final int number) {
        this.number = number;
    }

    private static int toInt(String number) {
        checkBlank(number);
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(INPUT_INTEGER + e.getMessage());
        }
    }

    private static void checkBlank(String number) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException(NULL_OR_BLANK_INPUT_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalcNumber number1 = (CalcNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
