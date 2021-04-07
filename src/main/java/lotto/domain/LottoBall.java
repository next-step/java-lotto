package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBall{

    public static final int MIN = 1;
    public static final int MAX = 45;
    private static final List<LottoBall> LOTTO_BALL_CACHE;

    static {
        LOTTO_BALL_CACHE = IntStream.range(MIN, MAX + 1)
                .mapToObj(LottoBall::new)
                .collect(Collectors.toList());
    }

    private final int number;

    private LottoBall(int number) {
        this.number = number;
    }

    public static LottoBall valueOf(int number) {
        validate(number);
        return LOTTO_BALL_CACHE.get(number - 1);
    }

    private static void validate(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("유효하지 않은 숫자");
        }
    }

    public static List<LottoBall> getAllBalls() {
        return LOTTO_BALL_CACHE;
    }

}
