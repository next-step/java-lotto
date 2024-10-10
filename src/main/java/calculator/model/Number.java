package calculator.model;

import calculator.util.StringUtil;

import java.util.Objects;

public class Number {
    private static final String PARSING_ERROR_MESSAGE = "숫자형식이 아닙니다.";
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public Number(String number) {
        this.number = validate(number);
    }

    public int getNumber() {
        return number;
    }

    private static boolean isNumber(String input) {
        return input.matches("[+-]?\\d*(\\.\\d+)?");
    }

    private static int validate(String input) {
        if (!isNumber(StringUtil.isEmpty(input))) {
            throw new NumberFormatException(PARSING_ERROR_MESSAGE);
        }
        return Integer.parseInt(input);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
