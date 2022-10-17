package lotto.domain;

public enum Rank {

    FIRST(1, 6), SECOND(2, 5), THIRD(3, 5),
    FOURTH(4, 4), FIFTH(5, 3),
    SIXTH(6, 2), SEVENTH(7, 1), EIGHTH(8, 0);

    private final int rank;
    private final int matchCount;
    private static final int REQUIRE_CHECK_BONUSNUMBER = 5;
    public static final int REWARD_START_RANK_INDEX = 4;
    public static final int REWARD_END_RANK_INDEX = 0;

    Rank(final int rank, int matchCount) {
        this.rank = rank;
        this.matchCount = matchCount;
    }

    public static Rank rankValue(final int matchCount, final boolean containBonusNumber) {
        if (matchCount == REQUIRE_CHECK_BONUSNUMBER) {
            return checkBonusNumber(containBonusNumber);
        }
        return rankValue(matchCount);
    }

    private static Rank rankValue(int matchCount) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return Rank.EIGHTH;
    }

    private static Rank checkBonusNumber(boolean containBonusNumber) {
        if (containBonusNumber) {
            return SECOND;
        }
        return THIRD;
    }

    public int rankValue() {
        return rank;
    }

    public int matchCount() {
        return matchCount;
    }

    @Override
    public String toString() {
        return String.valueOf(rank);
    }
}
