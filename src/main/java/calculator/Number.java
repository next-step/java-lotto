package calculator;

import java.util.Objects;

public class Number {
    private int value;

    public Number(String input) {
        this(Integer.parseInt(input));
    }

    public Number(int input) {
        this.value = input;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
