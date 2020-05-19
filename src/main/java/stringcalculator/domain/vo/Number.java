package stringcalculator.domain.vo;

import java.util.Objects;

public class Number {
    private static final int DEFAULT_NUMBER = 0;
    private final int value;

    private Number(int number) {
        this.value = number;
    }

    public static Number stringToNumber(String number) {
        if (isNullOrEmpty(number)) {
            return new Number(DEFAULT_NUMBER);
        }

        int parsedNumber = parseStringValueToInteger(number);
        validateNegative(parsedNumber);

        return new Number(parsedNumber);
    }

    public static Number sum(Number originalNumber, Number sourceNumber) {
        int result = originalNumber.value + sourceNumber.value;

        return new Number(result);
    }

    private static boolean isNullOrEmpty(String number) {
        return Objects.isNull(number) || number.isEmpty();
    }

    private static int parseStringValueToInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닙니다.");
        }
    }

    private static void validateNegative(int number) {
        if (number < 0) {
            throw new RuntimeException("음수가 입력되었습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Integer) {
            return value == (Integer) o;
        }
        if (!(o instanceof Number)) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
