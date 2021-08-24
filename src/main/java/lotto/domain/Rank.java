package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 1_500_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5000),
    NO_RANK(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prizeMoney;

    Rank(int matchCount, boolean matchBonus, int prizeMoney) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
    }

    public static Rank rank(int matchCount, boolean matchBonus) {
        if (matchCount < FIFTH.matchCount) {
            return NO_RANK;
        }
        if (SECOND.matchCount == matchCount) {
            return rankSecond(matchBonus);
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount(matchCount))
                .findFirst()
                .orElse(NO_RANK);
    }

    private boolean matchCount(int count) {
        return this.matchCount == count;
    }

    private static Rank rankSecond(boolean matchBonus) {
        if (matchBonus) {
            return SECOND;
        }
        return THIRD;
    }
}
