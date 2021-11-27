package lotto.domain;

import java.util.Arrays;

public enum Rank {
    OUT(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    FIRST(6, 2000000000);

    private final int matchCount;
    private final int prizeMoney;

    Rank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Rank matchNumber(long matchCount) {
        return Arrays.stream(values())
                    .filter(rank -> rank.matchCount == matchCount)
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
