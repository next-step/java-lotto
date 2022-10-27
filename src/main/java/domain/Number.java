package domain;

import java.util.Objects;

public class Number {
    private int number;

    public Number(String value) {
        try {
            this.number = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("입력값이 정수가 아닙니다.");
        }
    }

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private boolean isIntegerNumber(String value) {
        try {
            return (Double.valueOf(value)) % 1 == 0;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("입력값이 숫자가 아닙니다.");
        }
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
