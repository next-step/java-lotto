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

    public static Rank of(Lotto lotto, WinNumbers winNumbers) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == lotto.getMatchCount(winNumbers))
                .findFirst()
                .orElse(Rank.LOSE);
    }

    public long getPrize() {
        return this.prize;
    }
}
