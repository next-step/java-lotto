package lotto.domain;

import java.util.Objects;

public class Ball implements Comparable<Ball> {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    private Ball(int number) {
        validNumberRange(number);
        this.number = number;
    }

    public static Ball of(String text) {
        return new Ball(Integer.parseInt(text));
    }

    public static Ball of(int no) {
        return new Ball(no);
    }

    private void validNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("공 숫자는 " + MIN_NUMBER + "~" + MAX_NUMBER + " 만 올 수 있습니다.");
        }
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
