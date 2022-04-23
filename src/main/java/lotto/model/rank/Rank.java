package lotto.model.rank;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;

    private final long amount;

    Rank(int matchCount, long amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getAmount() {
        return amount;
    }

    public static Rank valueOf(int count, boolean matchBonus) {
        Rank expectedRank = Arrays.stream(values())
                .filter(rank -> rank.matchCount == count)
                .findFirst()
                .orElse(MISS);

        return checkSecondOrThird(expectedRank, matchBonus);
    }

    private static Rank checkSecondOrThird(Rank expectedRank, boolean matchBonus) {
        if (!isSecondOrThird(expectedRank)) {
            return expectedRank;
        }
        return matchBonus ? SECOND : THIRD;
    }

    private static boolean isSecondOrThird(Rank expectedRank) {
        return expectedRank == SECOND || expectedRank == THIRD;
    }

    public boolean isMiss() {
        return this == Rank.MISS;
    }

}
