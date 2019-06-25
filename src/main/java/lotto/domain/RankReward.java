package lotto.domain;

import java.util.List;

public class RankReward {
    private int[] gainRankCounts;
    private int rewardWinningMoney;

    public RankReward(List<Rank> ranks) {
        gainRankCounts = new int[Rank.values().length];
        setGainRankCounts(ranks);
    }

    private void setGainRankCounts(List<Rank> ranks) {
        for (Rank rank : ranks) {
            gainRankCounts[rank.ordinal()] = ++gainRankCounts[rank.ordinal()];
        }
    }

    public int[] getGainRankCounts() {
        return gainRankCounts;
    }

    public int getRewardWinningMoney() {
        for (int index = 0; index < gainRankCounts.length; index++) {
            rewardWinningMoney += Rank.values()[index].getWinningMoney() * gainRankCounts[index];
        }
        return rewardWinningMoney;
    }
}
