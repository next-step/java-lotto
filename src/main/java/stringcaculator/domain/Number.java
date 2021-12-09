package stringcaculator.domain;

import java.util.Objects;

public class Number {
    private final Value value;

    public Number(Value value) {
        this.value = value;
    }

    public Number sum(Number number) {
        return new Number(this.value.sum(number.value));
    }

    public int getValue() {
        return this.value.intValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number = (Number) o;
        return value.equals(number.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
