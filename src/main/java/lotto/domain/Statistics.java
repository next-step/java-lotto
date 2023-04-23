package lotto.domain;

import java.util.Arrays;

public enum Statistics {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    public static final int ZERO = 0;

    private final int matchingBall;
    private final int prize;

    Statistics(int matchingBall, int prize) {
        this.matchingBall = matchingBall;
        this.prize = prize;
    }

    public static Statistics initStatistics(int matchingBall) {
        return Arrays.stream(values())
                .filter(s -> s.matchingBall == matchingBall)
                .findFirst()
                .orElse(MISS);
    }

    public int getPrize() {
        return prize;
    }
}
