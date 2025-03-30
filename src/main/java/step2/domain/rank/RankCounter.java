package step2.domain.rank;

import java.util.HashMap;
import java.util.Map;

public class RankCounter {
    private final Map<Rank, Integer> rankCountMap;

    public RankCounter() {
        rankCountMap = new HashMap<>();
        for (Rank rank: Rank.values()) {
            rankCountMap.put(rank, 0);
        }
    }

    public int getCount(Rank rank) {
        return rankCountMap.getOrDefault(rank, 0);
    }

    public void increaseCount(Rank rank) {
        rankCountMap.put(rank, getCount(rank) + 1);
    }
}
