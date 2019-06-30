package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Ball {
    static final String OUT_OF_RANGE_MESSAGE = "로또 숫자 범위를 벗어났습니다.";
    static final int MINIMUM_VALUE = 1;
    static final int MAXIMUM_VALUE = 45;

    private static final Map<Integer, Ball> CACHE = new HashMap<>();
    private int value;

    private Ball(int value) {
        checkRange(value);
        this.value = value;
    }

    private void checkRange(int value) {
        if (value < MINIMUM_VALUE || value > MAXIMUM_VALUE) {
            throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE);
        }
    }

    public static Ball valueOf(int value) {
        Ball ball = CACHE.getOrDefault(value, new Ball(value));
        CACHE.putIfAbsent(value, ball);
        return ball;
    }

    public int toInteger() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return value == ball.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}