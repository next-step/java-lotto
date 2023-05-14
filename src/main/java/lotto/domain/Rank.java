package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final int SECOND_OR_THIRD_CONDITION = 5;
    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank findRank(int matchCount) {
        return Arrays.stream(values())
                .filter(item -> item.matchCount == matchCount)
                .findFirst()
                .orElse(MISS);
    }

    public static Rank findRank(int matchCount, boolean hasBonusNumber) {
        if (matchCount == SECOND_OR_THIRD_CONDITION) {
            return hasBonusNumber ? Rank.SECOND : Rank.THIRD;
        }
        return findRank(matchCount);
    }
}
