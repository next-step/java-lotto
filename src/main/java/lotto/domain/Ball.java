package lotto.domain;

import java.util.Objects;

public class Ball implements Comparable<Ball> {

    private final int number;

    public Ball(int number) {
        validNumberRange(number);
        this.number = number;
    }

    private void validNumberRange(int number) {
        if (number <= 0 || number >= 46)
            throw new IllegalArgumentException("공 숫자는 1~45 만 올 수 있습니다.");
    }

    @Override
    public int compareTo(Ball o) {
        return this.number - o.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
