package stringcalculator;

import java.util.Objects;

public class Number {
    private final int value;

    private Number(String stringNumber) {
        try {
            this.value = Integer.parseInt(stringNumber);
        } catch(Exception e){
            throw new IllegalArgumentException();
        }
    }

    private Number(int value) {
        this.value = value;
    }

    public static Number parse(String stringNumber) {
        return new Number(stringNumber);
    }

    public static Number of(int number) {
        return new Number(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Number)) {
            return false;
        }
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Number add(Number number) {
        return new Number(this.value + number.value);
    }

    public Number minus(Number number) {
        return new Number(this.value - number.value);
    }
}
