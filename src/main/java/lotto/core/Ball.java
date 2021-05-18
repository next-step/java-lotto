package lotto.core;

public class Ball implements Comparable {
    public static final int MIN = 1;
    public static final int MAX = 45;

    private int number;

    protected Ball(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(String.format("번호는 %d이상 %d이하의 숫자만 존재할수있습니다.", MIN, MAX));
        }

        this.number = number;
    }

    public int get() {
        return number;
    }

    @Override
    public int compareTo(Object obj) {
        Ball ball = (Ball) obj;

        return this.number - ball.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
