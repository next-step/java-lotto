package lotto.domain.rank;

import lotto.domain.LottoMatchCount;
import lotto.domain.money.ImmutableMoney;

public enum Rank {

    FIRST(1, 6, 2_000_000_000),
    SECOND(2, 5, 30_000_000),
    THIRD(3, 5, 1_500_000),
    FOURTH(4, 4, 50_000),
    FIFTH(5, 3, 5_000),
    MISS(6, 0, 0);

    private final int rank;
    private final LottoMatchCount matchCount;
    private final ImmutableMoney reward;
    public static final int REWARD_START_RANK_INDEX = 4;
    public static final int REWARD_END_RANK_INDEX = 0;

    Rank(final int rank, final int matchCount, int reward) {
        this.rank = rank;
        this.matchCount = new LottoMatchCount(matchCount);
        this.reward = new ImmutableMoney(reward);
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
        return Rank.MISS;
    }

    private static Rank checkBonusNumber(final boolean containBonusNumber) {
        if (containBonusNumber) {
            return SECOND;
        }
        return THIRD;
    }

    public ImmutableMoney reward() {
        return reward;
    }

    public boolean isBonus() {
        return this.equals(Rank.SECOND);
    }

    @Override
    public String toString() {
        return String.valueOf(rank);
    }
}
