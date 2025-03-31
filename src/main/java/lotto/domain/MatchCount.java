package lotto.domain;

import java.util.Arrays;

public enum MatchCount {

    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000),
    NONE(0, 0); // 기본값

    private final int matchCount;
    private final int prize;

    MatchCount(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static MatchCount of(int matchCount) {
        return Arrays.stream(values())
            .filter(count -> count.matchCount == matchCount)
            .findFirst()
            .orElse(NONE);
    }

    public boolean isAtLeast(MatchCount other) {
        return this.matchCount >= other.matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
