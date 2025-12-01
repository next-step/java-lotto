package domain;

import java.util.Objects;

public class Number {
    private int number;

    public Number(String number) {
        this(Integer.parseInt(number));
    }

    public Number(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
