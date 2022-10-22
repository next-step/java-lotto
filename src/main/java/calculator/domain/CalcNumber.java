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
        try {
            checkNullOrBlank(number);
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(INPUT_INTEGER + e.getMessage());
        }
    }

    private static void checkNullOrBlank(String number) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException(NULL_OR_BLANK_INPUT_ERROR_MESSAGE);
        }
    }

    public int number() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalcNumber that = (CalcNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
