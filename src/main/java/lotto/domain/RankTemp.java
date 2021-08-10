package lotto.domain;

public enum RankTemp {
    FIRST(new MatchingCount(6), 2_000_000_000, false),
    SECOND(new MatchingCount(5), 30_000_000, true),
    THIRD(new MatchingCount(5), 1_500_000, false),
    FOURTH(new MatchingCount(4), 50_000, false),
    FIFTH(new MatchingCount(3), 5_000, false),
    MISS(new MatchingCount(0), 0, false);

    private static final int MIN_HITS_COUNT = 0;
    private static final int MAX_HITS_COUNT = 6;
    private static final String OUT_OF_BOUNDS_ERROR_MESSAGE = "맞춘 횟수는 0에서 6 사이여야 합니다.";

    private final MatchingCount matchingCount;
    private final int winningMoney;
    private final boolean bonusStatus;

    RankTemp(final MatchingCount matchingCount, final int winningMoney, final boolean bonusStatus) {
        this.matchingCount = matchingCount;
        this.winningMoney = winningMoney;
        this.bonusStatus = bonusStatus;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public static RankTemp returnRank(final MatchingCount matchingCount, boolean matchBonus) {
        validateMatchingCount(matchingCount);

        if(FIFTH.matchingCount.getValue() > matchingCount.getValue()) {
            return MISS;
        }
        if(SECOND.matchingCount.equals(matchingCount) && matchBonus) {
            return SECOND;
        }
        if(THIRD.matchingCount.equals(matchingCount) && !matchBonus) {
            return THIRD;
        }

        RankTemp matchingRank = MISS;
        for (RankTemp rank : values()) {
            matchingRank = findMatchingRank(matchingCount, rank, matchingRank);
        }

        return matchingRank;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private static RankTemp findMatchingRank(final MatchingCount matchingCount, final RankTemp rank, final RankTemp matchingRank) {
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

    private int getWinningMoney() {
        return this.winningMoney;
    }

    private MatchingCount getMatchingCount() {
        return this.matchingCount;
    }

    public int totalWinningMoney(MatchingCount matchingCount) {
        return this.getWinningMoney() * matchingCount.getValue();
    }

    public boolean getBonusStatus() {
        return this.bonusStatus;
    }

}
