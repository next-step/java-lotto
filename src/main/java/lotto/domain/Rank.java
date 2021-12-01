package lotto.domain;

import java.util.Arrays;

public enum Rank {
    OUT(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int matchCount;
    private final int prizeMoney;

    Rank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Rank matchNumber(long matchCount, boolean matchBonus) {
        if (Rank.SECOND.matchCount == matchCount && matchBonus) {
            return Rank.SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank != Rank.SECOND)
                .findAny()
                .orElse(OUT);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
