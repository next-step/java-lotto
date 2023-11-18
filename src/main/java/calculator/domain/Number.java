package calculator.domain;

import java.util.Objects;

public class Number {

    private final int value;

    public Number(String number) {
        this.value = parseStringToNumber(number);
    }

    public Number(int number) {
        this.value = number;
    }

    private int parseStringToNumber(String input) {

        int number;
        try{
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }

        return number;
    }

    public Number plus(Number number) {

        return new Number(this.value + number.value);
    }

    public Number minus(Number number) {

        return new Number(this.value - number.value);
    }

    public Number multiply(Number number) {

        return new Number(this.value * number.value);
    }

    public Number divide(Number number) {
        if (number.value == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return new Number(this.value / number.value);
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return value == number1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
