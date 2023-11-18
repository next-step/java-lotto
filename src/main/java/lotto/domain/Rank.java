package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    ZERO(0, 0);

    public static final Rank[] VALUES = values();
    private int matchCount;
    private int prizeMoney;

    Rank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Rank rankByCount(int count) {
        return Arrays.stream(VALUES)
                .filter(rank -> rank.matchCount == count)
                .findFirst()
                .orElse(Rank.ZERO);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
