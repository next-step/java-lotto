package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;

    private final int prize;

    Rank(final int matchCount, final int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static int getRankingPrize(final int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findAny()
                .map(Rank::getPrize)
                .orElse(MISS.getPrize());
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .map(rank -> getMatchedRank(rank, matchBonus))
                .findAny()
                .orElse(MISS);
    }

    private static Rank getMatchedRank(Rank rank, boolean matchBonus) {
        if (rank.matchCount == SECOND.getMatchCount() && matchBonus) {
            return SECOND;
        }

        if (rank.matchCount == THIRD.getMatchCount()) {
            return THIRD;
        }

        return rank;
    }
}
