package calculator;

import java.util.Objects;

public class Number {

    private final int number;

    public Number(String number) {
        this(Integer.parseInt(number));
    }

    public Number(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 생성하실 수 없습니다");
        }
        this.number = number;
    }

    public Number sum(Number numberObject) {
        return new Number(this.number + numberObject.number);
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
}
