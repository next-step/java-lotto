package step2.domain;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    NONE(0, 0);
    private final int matchedCount;
    private final int reward;

    Rank(int matchedCount, int reward) {
        this.matchedCount = matchedCount;
        this.reward = reward;
    }

    public static Rank from(int matchedCount) {
        return Arrays.stream(values())
                .filter(r -> r.matchedCount == matchedCount)
                .findFirst()
                .orElse(NONE);
    }

    public static Rank from(int matchedCount, boolean isBonusMatched) {
        if (matchedCount == 5) {
            return isBonusMatched ? SECOND : THIRD;
        }

        return Arrays.stream(values())
                .filter(r -> r.matchedCount == matchedCount)
                .findFirst()
                .orElse(NONE);
    }

    public int reward() {
        return reward;
    }

    public boolean isWinning() {
        return this != NONE;
    }

    public int matchedCount() {
        return matchedCount;
    }
}
