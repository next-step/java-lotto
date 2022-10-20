package domain;

import java.util.Objects;

public class Number {
    int number;

    public Number(String value) {
        if (!isIntegerNumber(value)) {
            throw new NumberFormatException("정수가 아닙니다.");
        }
        this.number = Integer.valueOf(value);
    }

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private boolean isIntegerNumber(String value) {
        return (Double.valueOf(value)) % 1 == 0;
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
