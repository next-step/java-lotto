package stringAddCalculator.model;

import java.util.Objects;

public class Number {
    private int number;

    public Number(int number) {
        if (number < 0){
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        this.number = number;
    }

    public Number(String number) {
        this(Integer.parseInt(number));
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

    public int value() {
        return number;
    }
}
