package lotto;

import java.util.Objects;

public class Ball {

    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 45;
    private int number;

    private Ball(int number) {
        this.number = number;
    }

    public static Ball of(int number) {
        validateNumber(number);
        return new Ball(number);
    }

    private static void validateNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(String.format("볼은 %d ~ %d 사이의 숫자만 생성가능합니다.", MIN_NUMBER, MAX_NUMBER));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "number=" + number +
                '}';
    }
}
