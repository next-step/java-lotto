package domain;

import java.util.Objects;

public class Number {
    private Integer number;

    public Number(Integer number) {
        if (number < 1 || number > 46) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number1 = (Number) o;
        return Objects.equals(number, number1.number);
    }
}
