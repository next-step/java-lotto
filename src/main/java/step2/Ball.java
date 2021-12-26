package step2;

import java.util.Objects;

public class Ball implements Comparable<Ball>{

    public static final String VALID_BALL_NUMBER_MSG = "로또공의 숫자는 1부터 45사이여야 합니다.";
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;

    public final int number;

    public Ball(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(VALID_BALL_NUMBER_MSG);
        }
        this.number = number;
    }

    public Ball(String number) {
        this(Integer.parseInt(number.trim()));
    }
    public Ball(Ball ball) {
        this.number = ball.number;
    }

    @Override
    public int compareTo(Ball o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public String toString() {
        return number + "";
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
