package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.exception.Message.RANGE_MESSAGE;

public class LottoBall implements Comparable<LottoBall> {

    public static final int MIN = 1;
    public static final int MAX = 45;
    private static final List<LottoBall> LOTTO_BALL_CACHE;

    static {
        LOTTO_BALL_CACHE = IntStream.range(MIN, MAX + 1)
                .mapToObj(LottoBall::new)
                .collect(Collectors.toList());
    }

    private final int number;

    public LottoBall(int number) {
        this.number = number;
    }

    public static LottoBall valueOf(int number) {
        validate(number);
        return LOTTO_BALL_CACHE.get(number - 1);
    }

    private static void validate(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(RANGE_MESSAGE);
        }
    }

    public static List<LottoBall> getAllBalls() {
        return LOTTO_BALL_CACHE;
    }

    public String toStringValue() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoBall lottoBall) {
        return this.number - lottoBall.number;
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
