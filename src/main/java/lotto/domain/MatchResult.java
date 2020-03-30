package lotto.domain;

import lotto.type.RankType;

import java.util.HashMap;
import java.util.Map;

public class MatchResult {
    private static final int ADD_COUNT = 1;
    private Map<RankType, Integer> rankCountMap;

    public MatchResult() {
        this.rankCountMap = new HashMap<>();

        for (RankType rankType : RankType.values()) {
            rankCountMap.put(rankType, 0);
        }
    }

    public void addResult(RankType rankType) {
        int count = rankCountMap.get(rankType) + ADD_COUNT;

        rankCountMap.put(rankType, count);
    }

    public int getCount(RankType rankType) {
        return rankCountMap.get(rankType);
    }

    public int getTotalReward() {
        int totalReward = 0;

        for (Map.Entry<RankType, Integer> rankCountEntry : rankCountMap.entrySet()) {
            RankType rankType = rankCountEntry.getKey();
            int count = rankCountEntry.getValue();

            totalReward += rankType.getTotalReward(count);
        }

        return totalReward;
    }
}
