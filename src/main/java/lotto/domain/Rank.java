package lotto.domain;

public enum Rank {

    FIRST(1, new LottoMatchCount(6)), SECOND(2, new LottoMatchCount(5)), THIRD(3, new LottoMatchCount(5)),
    FOURTH(4, new LottoMatchCount(4)), FIFTH(5, new LottoMatchCount(3)),
    SIXTH(6, new LottoMatchCount(2)), SEVENTH(7, new LottoMatchCount(1)), EIGHTH(8, new LottoMatchCount(0));

    private final int rank;
    private final LottoMatchCount matchCount;
    public static final int REWARD_START_RANK_INDEX = 4;
    public static final int REWARD_END_RANK_INDEX = 0;

    Rank(final int rank, final LottoMatchCount matchCount) {
        this.rank = rank;
        this.matchCount = matchCount;
    }

    public static Rank rankValue(final LottoMatchCount matchCount, final boolean containBonusNumber) {
        if (matchCount.equals(LottoMatchCount.REQUIRE_CHECK_BONUSNUMBER)) {
            return checkBonusNumber(containBonusNumber);
        }
        return rankValue(matchCount);
    }

    private static Rank rankValue(final LottoMatchCount matchCount) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount.equals(matchCount)) {
                return rank;
            }
        }
        return Rank.EIGHTH;
    }

    private static Rank checkBonusNumber(final boolean containBonusNumber) {
        if (containBonusNumber) {
            return SECOND;
        }
        return THIRD;
    }

    public LottoMatchCount matchCount() {
        return matchCount;
    }

    public int index() {
        return rank - 1;
    }

    @Override
    public String toString() {
        return String.valueOf(rank);
    }

}
