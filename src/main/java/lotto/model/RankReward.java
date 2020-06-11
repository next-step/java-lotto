package lotto.model;

import java.util.List;

public class RankReward {

    private List<Rank> rankList;

    public RankReward(List<Rank> rankList) {
        this.rankList = rankList;
    }

    public int getWinnerCount(RewardStatus rewardStatus) {
        return (int) rankList
                        .stream()
                        .filter(o -> o.getCountOfMatch() == rewardStatus.getMatchingCount()
                                        && o.getBonus() == rewardStatus.isMatchingBonus()).count();
    }

    public int getTotalPrize() {
        return rankList.stream().mapToInt(Rank::getWinningMoney).sum();
    }


}
