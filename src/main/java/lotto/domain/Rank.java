package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIFTH(2, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final int matchingNumberCount;
    private final int prizeMoney;

    Rank(int matchingNumberCount, int prizeMoney) {
        this.matchingNumberCount = matchingNumberCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Rank value(int matchingCount) {
        if (matchingCount < 3) {
            return FIFTH;
        }
        return Arrays.stream(values())
                .filter(value -> value.matchingNumberCount == matchingCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("number is wrong rank."));
    }
}
