package lotto;

import java.util.Objects;

public class Number implements Comparable<Number> {
    private final int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number other = (Number) o;
        return number == other.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(Number o) {
        if (this.number >= o.number) {
            return 1;
        }
        return -1;
    }
}
