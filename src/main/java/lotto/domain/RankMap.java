package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class RankMap {

    private Map<Rank, Integer> rankMap;

    public RankMap() {
        this.rankMap = new HashMap<>();
    }

    public void addRank(Rank rank) {
        int count = rankMap.getOrDefault(rank, 0);
        rankMap.put(rank, count + 1);
    }

    public double getProfitRate(int totalLottoCnt) {
        int countSum = 0;
        for (Rank rank : rankMap.keySet()) {
            countSum += rank == Rank.MISS ? 0 : rankMap.get(rank);
        }
        return (double) countSum / totalLottoCnt;
    }

    public int getRankCount(Rank rank) {
        if (!rankMap.containsKey(rank)) {
            return 0;
        }
        return rankMap.get(rank);
    }

}
