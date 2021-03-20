package lotto.domain;

import java.util.Objects;

public class Number implements Comparable<Number> {
    private final int value;

    public Number(final String value) {
        this(Integer.parseInt(value));
    }

    public Number(final int value) {
        validation(value);
        this.value = value;
    }

    public void validation(final int value) {
        if (value <= 0 || value > 45)
            throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
    }

    public int value() {
        return value;
    }

    @Override
    public int compareTo(Number o) {
        if (value == o.value) return 0;
        return (value > o.value) ? 1 : -1;
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
        return String.valueOf(value);
    }
}
