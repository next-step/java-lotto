package stringcalculator.domain;

import java.util.Objects;

public class OperandNumber {

    private final int number;

    public OperandNumber(String input) {
        this(convertNumberType(input));
    }

    public OperandNumber(int number) {
        checkPostitiveNumber(number);
        this.number = number;
    }

    public static void checkPostitiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("[Error]: 양수만 연산 가능합니다.");
        }
    }

    public static int convertNumberType(final String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[Error]: 숫자만 연산 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OperandNumber number1 = (OperandNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public int getNumber() {
        return number;
    }
}
