package step2.domain;

import java.util.List;
import java.util.Objects;

public class Number implements Comparable<Number> {

    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private final int value;

    public Number(int value) {
        if (value < MIN_NUMBER || value > MAX_NUMBER) {
            throw new IllegalArgumentException("1에서 45 사이의 수를 입력해주세요.");
        }

        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return MIN_NUMBER == number.MIN_NUMBER && MAX_NUMBER == number.MAX_NUMBER && value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Number o) {
        return 1;
    }
}
