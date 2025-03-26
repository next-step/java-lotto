package step2.domain;

import java.util.Arrays;

public enum Rank {
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000),
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

    public int reward() {
        return reward;
    }

    public boolean isWinning() {
        return this != NONE;
    }
}
