package lotto.domain.rank;

import lotto.domain.LottoMatchCount;
import lotto.domain.money.Money;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Rank {

    FIRST(1, 6, 2_000_000_000),
    SECOND(2, 5, 30_000_000),
    THIRD(3, 5, 1_500_000),
    FOURTH(4, 4, 50_000),
    FIFTH(5, 3, 5_000),
    MISS(6, 0, 0);

    private final int rank;
    private final LottoMatchCount matchCount;
    private final Money reward;
    public static final int REWARD_START_RANK_INDEX = 4;
    public static final int REWARD_END_RANK_INDEX = 0;

    Rank(final int rank, final int matchCount, int reward) {
        this.rank = rank;
        this.matchCount = new LottoMatchCount(matchCount);
        this.reward = new Money(reward);
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

    public static List<Rank> rewardDescendingRankList() {
        List<Rank> rankList = Arrays.asList(Arrays.copyOfRange(Rank.values(), Rank.REWARD_END_RANK_INDEX, Rank.REWARD_START_RANK_INDEX + 1));
        Collections.reverse(rankList);
        return rankList;
    }

    public LottoMatchCount matchCount() {
        return matchCount;
    }

    public Money reward() {
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
