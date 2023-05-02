package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    LOSE(2, 0);

    private final int matchCount;
    private final long prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank fromMatchCount(long matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(Rank.LOSE);
    }

    public boolean isFirstRank() {
        return this.matchCount == 6;
    }

    public boolean isSecondRank() {
        return this.matchCount == 5;
    }

    public boolean isThirdRank() {
        return this.matchCount == 4;
    }

    public boolean isFourthRank() {
        return this.matchCount == 3;
    }

    public long getPrize() {
        return this.prize;
    }
}
