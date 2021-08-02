package lotto.domain;

import java.util.Objects;

public class Ball implements Comparable<Ball> {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final String NUMBER_RANGE_EXCEPTION_MESSAGE = "공 숫자는 " + MIN_NUMBER + "~" + MAX_NUMBER + " 만 올 수 있습니다.";
    private final int number;

    public Ball(int number) {
        validNumberRange(number);
        this.number = number;
    }

    private void validNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER)
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION_MESSAGE);
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
