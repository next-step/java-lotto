package stringcalculator.domain.vo;

import java.util.Objects;

public class Number {
    private final int value;

    private Number(int number) {
        this.value = number;
    }

    public static Number stringToNumber(String number) {
        validateNullOrEmpty(number);
        int parsedNumber = parseStringValueToInteger(number);
        validateNegative(parsedNumber);

        return new Number(parsedNumber);
    }

    public int getValue() {
        return value;
    }

    public static Number sum(Number originalNumber, Number sourceNumber) {
        int result = originalNumber.value + sourceNumber.value;

        return new Number(result);
    }

    private static void validateNullOrEmpty(String number) {
        if (Objects.isNull(number) || number.isEmpty()) {
            throw new RuntimeException("빈문자열 또는 Null이 입력되었습니다.");
        }
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
