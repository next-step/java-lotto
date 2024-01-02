package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),

    SECOND(5, 30_000_000),

    THIRD(5, 1_500_000),

    FOURTH(4, 50_000),

    FIFTH(3, 5_000),

    MISS(0, 0);

    private final int duplicateCount;
    private final int prizeAmount;

    Rank(int duplicateCount, int prizeAmount) {
        this.duplicateCount = duplicateCount;
        this.prizeAmount = prizeAmount;
    }

    public static int calculate(Rank rank, int lottoCount) {
        return findPrizeAmount(rank) * lottoCount;
    }

    public static Rank findRankByDuplicateCount(int duplicateCount, boolean containsBonusNumber) {
        if (duplicateCount == 5) {
            return containsBonusNumber ? Rank.SECOND : Rank.THIRD;
        }

        return Arrays.stream(Rank.values())
                     .filter(rank -> rank.duplicateCount == duplicateCount)
                     .findFirst()
                     .orElse(Rank.MISS);
    }

    public static int findPrizeAmount(Rank rank) {
        return rank.prizeAmount;
    }
}
