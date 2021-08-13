package lotto.domain;

public enum Rank {

    MISS(0, (matchingCount, isBonus) -> matchingCount.isLowerValue(3)),
    FIFTH(5_000, (matchingCount, isBonus) -> matchingCount.isSameValue(3)),
    FOURTH(50_000, (matchingCount, isBonus) -> matchingCount.isSameValue(4)),
    THIRD(1_500_000, (matchingCount, isBonus) -> matchingCount.isSameValue(5) && !isBonus),
    SECOND(30_000_000, (matchingCount, isBonus) -> matchingCount.isSameValue(5) && isBonus),
    FIRST(2_000_000_000, (matchingCount, isBonus) -> matchingCount.isSameValue(6));

    private final int winningMoney;
    private final WinningStrategy winningStrategy;

    Rank(final int winningMoney, final WinningStrategy winningStrategy) {
        this.winningMoney = winningMoney;
        this.winningStrategy = winningStrategy;
    }

    public static Rank findRank(final MatchingCount matchingCount, final boolean isBonus) {
        Rank rankingFound = Rank.MISS;
        for (Rank rank : values()) {
            rankingFound = rank.getConditionalRank(rankingFound, matchingCount, isBonus);
        }
        return rankingFound;
    }

    private Rank getConditionalRank(final Rank rank, final MatchingCount matchingCount, final boolean isBonus) {
        if (winningStrategy.winnable(matchingCount, isBonus)) {
            return this;
        }
        return rank;
    }

    public int totalWinningMoney(final int hitCount) {
        return this.winningMoney * hitCount;
    }

}
