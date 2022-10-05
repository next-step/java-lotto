package calculator.model;

import java.util.Objects;

public class Number {

    static final String DIVIDE_BYZERO_ERROR_MESSAGE = "나누기를 진행할 때 0으로 나눌 수 없습니다.";
    static final String INT_PATTERN = "-?\\d+";

    private final int number;

    public Number(String number) {
        this.number = Integer.parseInt(number);
    }

    public Number(int number) {
        this.number = number;
    }

    public static boolean isInteger(String string) {
        return string.matches(INT_PATTERN);
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public Number plus(Number number) {
        return new Number(this.number + number.number);
    }

    public Number minus(Number number) {
        return new Number(this.number - number.number);
    }

    public Number multiply(Number number) {
        return new Number(this.number * number.number);
    }

    public Number divide(Number number) {
        if (number.number == 0) {
            throw new ArithmeticException(DIVIDE_BYZERO_ERROR_MESSAGE);
        }
        return new Number(this.number / number.number);
    }
}
