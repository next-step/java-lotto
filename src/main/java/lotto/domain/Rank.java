package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int match;
    private final int prize;

    Rank(int match, int prize) {
        this.match = match;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, boolean isMatchBonus) {
        if (SECOND.isSameOf(matchCount)) {
            return decideBonusRank(isMatchBonus);
        }

        return getRank(matchCount);
    }

    private static Rank decideBonusRank(boolean isMatchBonus) {
        return isMatchBonus ? SECOND : THIRD;
    }

    private static Rank getRank(int matchCount) {
        Rank returnRank = MISS;

        for (Rank rank : values()) {
            returnRank = getMatched(matchCount, rank, returnRank);
        }

        return returnRank;
    }

    private static Rank getMatched(int matchCount, Rank rank, Rank returnPrize) {
        if (rank.isSameOf(matchCount)) {
            return rank;
        }
        return returnPrize;
    }

    private boolean isSameOf(int matchCount) {
        return this.match == matchCount;
    }

    public int calculatePrize(int winCounts) {
        return this.prize * winCounts;
    }

    public int getMatch() {
        return match;
    }

    public Integer getPrize() {
        return prize;
    }
}
