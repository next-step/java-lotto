package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank of(int matchCount, boolean matchBounus) {
        if (matchCount == THIRD.matchCount && !matchBounus) {
            return THIRD;
        }
        if (matchCount == SECOND.matchCount && matchBounus) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> matchCount == rank.matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
