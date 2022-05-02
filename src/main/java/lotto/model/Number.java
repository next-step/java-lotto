package lotto.model;

import java.util.Objects;

public class Number {

    private long value;

    public Number() {
    }

    public Number(long value) {
        this.value = value;
    }

    public Number incrementAndGet() {
        this.value++;
        return this;
    }

    public Number add(Number number) {
        long value = this.value + number.value;
        return new Number(value);
    }

    public Number multiple(Number number) {
        long value = this.value * number.value;
        return new Number(value);
    }

    public long getValue() {
        return this.value;
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

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
