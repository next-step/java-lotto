package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NOTHING(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private final int countOfMatch;
    private final long prizeMoney;

    Rank(int countOfMatch, long prizeMoney) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public static Rank valeOf(int countOfMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findFirst()
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
