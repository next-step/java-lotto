package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchingNumberCount;
    private final int prizeMoney;
    private final boolean matchBonus;

    Rank(int matchingNumberCount, int prizeMoney, boolean matchBonus) {
        this.matchingNumberCount = matchingNumberCount;
        this.prizeMoney = prizeMoney;
        this.matchBonus = matchBonus;
    }

    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Rank value(int matchingCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(value -> value.matchingNumberCount == matchingCount)
                .filter(value -> value.matchBonus == matchBonus)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("number is wrong rank."));
    }
}
