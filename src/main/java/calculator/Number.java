package calculator;

import java.util.Objects;

public class Number {
    private int number;

    public Number(String number) {
        if (number == null) {
            throw new IllegalArgumentException("숫자가 NULL이면 안됩니다.");
        }
        if (number.equals("")) {
            throw new IllegalArgumentException("숫자가 빈값이면 안됩니다.");
        }
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자로 변환할 수 없습니다.");
        }
        this.number = Integer.parseInt(number);
    }

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
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

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
