package calculator;

import java.util.Objects;

public class Number {
    private static final String numberRegExp = "^[-]?[0-9]+$";
    private int number;

    public Number(String stringNum) {
        validCheck(stringNum);
        this.number = Integer.parseInt(stringNum);
    }

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validCheck(String input) {
        if (!input.matches(numberRegExp)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    public Number plus(Number other) {
        return new Number(this.number + other.getNumber());
    }

    public Number minus(Number other) {
        return new Number(this.number - other.getNumber());
    }

    public Number multiply(Number other) {
        return new Number(this.number * other.getNumber());
    }

    public Number divide(Number other) {
        return new Number(this.number / other.getNumber());
    }

}
