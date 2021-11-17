package stringformula;

import stringformula.exception.InvalidNumberValueException;

import java.util.Objects;

public class Number {
    private final int value;

    public Number(int value) {
        if (value < 0) {
            throw new InvalidNumberValueException();
        }

        this.value = value;
    }

    public Number plus(Number number) {
        return new Number(this.value + number.value);
    }

    public static Number valueOf(String value) {
        return new Number(Integer.parseInt(value));
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
