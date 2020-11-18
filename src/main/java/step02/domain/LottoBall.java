package step02.domain;

import java.util.Objects;

public class LottoBall {
    private final int number;
    private final int count;

    private LottoBall(int number, int count) {
        this.number = number;
        this.count = count;
    }

    public static LottoBall of(int number, int count) {
        return new LottoBall(number, count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBall that = (LottoBall) o;
        return number == that.number &&
                count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, count);
    }

    public boolean filter(int from, int to) {
        return from <= number && number <= to;
    }
}
