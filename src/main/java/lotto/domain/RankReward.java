package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankReward {

    private Map<Rank, Integer> gainRanksCounts;

    public RankReward(List<Rank> ranks) {
        this.gainRanksCounts = new HashMap<>();
        for (Rank rank : Rank.values()) {
            gainRanksCounts.put(rank, ranks.stream()
                    .filter(gainRank->gainRank == rank)
                    .collect(Collectors.toList()).size());
        }
    }

    public Map<Rank, Integer> getGainRanksCounts() {
        return gainRanksCounts;
    }

    public int getRewardWinningMoney() {
        int rewardWinningMoney = 0;
        for (Rank rank : Rank.values()) {
            rewardWinningMoney += gainRanksCounts.get(rank) * rank.getWinningMoney();
        }
        return rewardWinningMoney;
    }
}
