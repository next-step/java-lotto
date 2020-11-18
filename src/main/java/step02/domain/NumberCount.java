package step02.domain;

import java.util.Objects;

public class NumberCount {
    private final int number;
    private final int count;

    private NumberCount(int number, int count) {
        this.number = number;
        this.count = count;
    }

    public static NumberCount of(int number, int count) {
        return new NumberCount(number, count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberCount that = (NumberCount) o;
        return number == that.number &&
                count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, count);
    }
}
