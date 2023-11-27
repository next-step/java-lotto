package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NOTHING(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int countOfMatch;
    private final boolean containsBonus;
    private final long prizeMoney;

    Rank(int countOfMatch, boolean containsBonus, long prizeMoney) {
        this.countOfMatch = countOfMatch;
        this.containsBonus = containsBonus;
        this.prizeMoney = prizeMoney;
    }

    public static Rank valeOf(int countOfMatch, boolean containsBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findFirst()
                .map(matchedRank -> matchedRank == THIRD && containsBonus ? SECOND : matchedRank)
                .orElse(NOTHING);
    }

    public long calculateTotalPrizePerRank(long rankCnt) {
        return this.prizeMoney * rankCnt;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
