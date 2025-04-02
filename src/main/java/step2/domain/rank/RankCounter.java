package step2.domain.rank;

import java.util.HashMap;
import java.util.Map;

public class RankCounter {
    private final Map<RankType, Integer> rankCountMap;

    public RankCounter() {
        rankCountMap = new HashMap<>();
        for (RankType rank: RankType.values()) {
            rankCountMap.put(rank, 0);
        }
    }

    public int getCount(RankType rank) {
        return rankCountMap.getOrDefault(rank, 0);
    }

    public void increaseCount(RankType rank) {
        rankCountMap.put(rank, getCount(rank) + 1);
    }
}
