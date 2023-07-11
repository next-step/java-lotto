package lotto.model.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean hasBonusBall;
    private final long prize;

    Rank(final int matchCount, final boolean hasBonusBall, final int prize) {
        this.matchCount = matchCount;
        this.hasBonusBall = hasBonusBall;
        this.prize = prize;
    }

    public static Rank valueOf(final int matchCount, final boolean hasBonusBall) {
        // TODO refactor
        if (matchCount == 5 && hasBonusBall) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public static long getTotalPrize(Rank rank, int count) {
        return rank.prize * count;
    }
}
