package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

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

    public static Rank value(int matchingCount, boolean matchBonus) {
        if (matchingCount < 3) {
            return NONE;
        }

        if (matchingCount == 5 && matchBonus) {
            return SECOND;
        }

        if (matchingCount == 5) {
            return THIRD;
        }
        return Arrays.stream(values())
                .filter(value -> value.matchingNumberCount == matchingCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("number is wrong rank."));
    }
}
