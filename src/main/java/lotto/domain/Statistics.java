package lotto.domain;

import java.util.Arrays;

public enum Statistics {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final int SECOND_OR_THIRD_NUMBER = 5;

    private final int matchingBall;
    private final int prize;

    Statistics(int matchingBall, int prize) {
        this.matchingBall = matchingBall;
        this.prize = prize;
    }

    public static Statistics initStatistics(int matchingBall, boolean isBonus) {
        if (isSecondPrize(matchingBall, isBonus)) {
            return Statistics.SECOND;
        }

        return Arrays.stream(values())
                .filter(s -> s!= SECOND)
                .filter(s -> hasMatchingBall(matchingBall, s))
                .findFirst()
                .orElse(MISS);
    }

    private static boolean hasMatchingBall(int matchingBall, Statistics statistics) {
        return statistics.matchingBall == matchingBall;
    }

    private static boolean isSecondPrize(int matchingBall, boolean isBonus) {
        return matchingBall == SECOND_OR_THIRD_NUMBER && isBonus;
    }

    public int getTotalPrize(int count) {
        return prize * count;
    }

    public int getMatchingBall() {
        return matchingBall;
    }

    public int getPrize() {
        return prize;
    }
}
