package step03.domain;

import java.util.Objects;

public class LottoBall {
    private final int number;

    private LottoBall(int number) {
        this.number = number;
    }

    public static LottoBall of(int number) {
        return new LottoBall(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBall lottoBall = (LottoBall) o;
        return number == lottoBall.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
