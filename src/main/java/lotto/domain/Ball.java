package lotto.domain;

import java.util.Objects;

public class Ball {

    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;
    private static final String NUMBER_RANGE_EXCEPTION_MESSAGE
        = "공 번호는 " + LOWER_BOUND + "~" + UPPER_BOUND + " 사이만 가능합니다";

    private final int number;

    public Ball(int number) {
        if (number < LOWER_BOUND || number > UPPER_BOUND) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
        this.number = number;
    }

    public int number() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
