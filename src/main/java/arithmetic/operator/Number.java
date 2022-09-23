package arithmetic.operator;

import java.util.Objects;

public class Number {
    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public Number plus(Number other) {
        return new Number(value + other.value);
    }

    public Number minus(Number other) {
        return new Number(value - other.value);
    }

    public Number multiply(Number other) {
        return new Number(value * other.value);
    }

    public Number divide(Number other) {
        return new Number(value / other.value);
    }
    
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Number number = (Number) other;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
