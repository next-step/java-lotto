package lotto.domain;

public enum Rank {

    MISS(new MatchingCount(0), 0),
    FIFTH(new MatchingCount(3), 5_000),
    FOURTH(new MatchingCount(4), 50_000),
    THIRD(new MatchingCount(5), 1_500_000),
    SECOND(new MatchingCount(5), 30_000_000),
    FIRST(new MatchingCount(6), 2_000_000_000);

    private final MatchingCount matchingCount;
    private final int winningMoney;

    Rank(final MatchingCount matchingCount, final int winningMoney) {
        this.matchingCount = matchingCount;
        this.winningMoney = winningMoney;
    }

    public static Rank returnRank(final MatchingCount matchingCount, final boolean matchBonus) {
        Rank matchingRank = MISS;

        for (Rank rank : values()) {
            matchingRank = findMatchingRank(matchingCount, matchBonus, rank, matchingRank);
        }

        return matchingRank;
    }

    private static Rank findMatchingRank(final MatchingCount matchingCount, final boolean matchBonus, final Rank rank, final Rank matchingRank) {
        if (matchingRank != MISS || !rank.equalsMatchingCount(matchingCount)) {
            return matchingRank;
        }

        if (SECOND.matchingCount.equals(matchingCount) && matchBonus) {
            return SECOND;
        }
        if (THIRD.matchingCount.equals(matchingCount) && !matchBonus) {
            return THIRD;
        }

        return rank;
    }

    public boolean equalsMatchingCount(final MatchingCount matchingCount) {
        return this.matchingCount.equals(matchingCount);
    }

    public int totalWinningMoney(final int hitCount) {
        return this.winningMoney * hitCount;
    }

    public MatchingCount getMatchingCount() {
        return this.matchingCount;
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

}
