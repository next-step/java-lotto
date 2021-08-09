package lotto.domain;

public enum Rank {
    FIRST(new MatchingCount(6), 2_000_000_000),
    SECOND(new MatchingCount(5), 1_500_000),
    THIRD(new MatchingCount(4), 50_000),
    FOURTH(new MatchingCount(3), 5_000),
    MISS(new MatchingCount(0), 0);

    private static final int MIN_HITS_COUNT = 0;
    private static final int MAX_HITS_COUNT = 6;
    private static final String OUT_OF_BOUNDS_ERROR_MESSAGE = "맞춘 횟수는 0에서 6 사이여야 합니다.";

    private final MatchingCount matchingCount;
    private final int winningMoney;

    Rank(final MatchingCount matchingCount, final int winningMoney) {
        this.matchingCount = matchingCount;
        this.winningMoney = winningMoney;
    }

    public static Rank returnRank(final MatchingCount matchingCount) {
        validateMatchingCount(matchingCount);

        Rank matchingRank = MISS;
        for (Rank rank : values()) {
            matchingRank = findMatchingRank(matchingCount, rank, matchingRank);
        }

        return matchingRank;
    }

    private static Rank findMatchingRank(final MatchingCount matchingCount, final Rank rank, final Rank matchingRank) {
        if (matchingRank != MISS) {
            return matchingRank;
        }
        if (matchingCount.equals(rank.getMatchingCount())) {
            return rank;
        }
        return MISS;
    }

    private static void validateMatchingCount(final MatchingCount matchingCount) {
        if (matchingCount.getValue() < MIN_HITS_COUNT || matchingCount.getValue() > MAX_HITS_COUNT) {
            throw new IllegalArgumentException(OUT_OF_BOUNDS_ERROR_MESSAGE);
        }
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

    private MatchingCount getMatchingCount() {
        return this.matchingCount;
    }

}
