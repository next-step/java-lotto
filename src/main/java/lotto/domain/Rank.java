package lotto.domain;

import lotto.domain.Money.ImmutableMoney;

public enum Rank {

    FIRST(1, new LottoMatchCount(6), new ImmutableMoney(2_000_000_000)),
    SECOND(2, new LottoMatchCount(5), new ImmutableMoney(30_000_000)), THIRD(3, new LottoMatchCount(5), new ImmutableMoney(1_500_000)),
    FOURTH(4, new LottoMatchCount(4), new ImmutableMoney(50_000)), FIFTH(5, new LottoMatchCount(3), new ImmutableMoney(5_000)),
    SIXTH(6, new LottoMatchCount(2), new ImmutableMoney(0)), SEVENTH(7, new LottoMatchCount(1), new ImmutableMoney(0)), EIGHTH(8, new LottoMatchCount(0), new ImmutableMoney(0));

    private final int rank;
    private final LottoMatchCount matchCount;
    private final ImmutableMoney reward;
    public static final int REWARD_START_RANK_INDEX = 4;
    public static final int REWARD_END_RANK_INDEX = 0;

    Rank(final int rank, final LottoMatchCount matchCount, ImmutableMoney reward) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.reward = reward;
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

    public ImmutableMoney reward() {
        return reward;
    }

    @Override
    public String toString() {
        return String.valueOf(rank);
    }

}
