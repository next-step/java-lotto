package step2.domain;

import java.util.Objects;

public class Number implements Comparable<Number> {

    private final int value;

    public Number(int value) {
        if (value <= 0 || value >= 46) {
            throw new IllegalArgumentException("1~45까지 입력가능합니다.");
        }
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Number o) {
        return Integer.compare(this.value, o.value());
    }

    @Override
    public String toString() {
        return String.valueOf(value);
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
}
