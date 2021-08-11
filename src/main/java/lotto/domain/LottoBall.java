package lotto.domain;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBall {
    public static final int LOTTO_BALL_NUMBER_MIN = 1;
    public static final int LOTTO_BALL_NUMBER_MAX = 45;
    private static final Map<Integer, LottoBall> LOTTO_BALLS =
        IntStream.rangeClosed(LOTTO_BALL_NUMBER_MIN, LOTTO_BALL_NUMBER_MAX)
            .mapToObj(LottoBall::new)
            .collect(Collectors.toMap(LottoBall::number, Function.identity()));

    private final int number;

    private LottoBall(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoBall select(int number) {
        validate(number);
        return LOTTO_BALLS.get(number);
    }

    private static void validate(int number) {
        if (number < LOTTO_BALL_NUMBER_MIN) {
            throw new RuntimeException("입력된 로또숫자가 " + LOTTO_BALL_NUMBER_MIN + "미만입니다.");
        }

        if (number > LOTTO_BALL_NUMBER_MAX) {
            throw new RuntimeException("입력된 로또숫자가 " + LOTTO_BALL_NUMBER_MAX + "초과합니다.");
        }
    }

    public int number() {
        return number;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        LottoBall lottoBall = (LottoBall)object;
        return number == lottoBall.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
