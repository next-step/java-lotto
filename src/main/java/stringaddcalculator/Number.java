package stringaddcalculator;

import java.util.Objects;

public class Number {

    private final int value;

    public Number(int input) {
        value = input;
    }

    public static Number init() {
        return new Number(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
