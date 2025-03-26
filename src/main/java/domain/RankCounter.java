package domain;

import domain.lotto.Rank;

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

    public int getWinningsSum() {
        int sum = 0;
        for (Rank rank: rankCountMap.keySet()) {
            sum += rank.getTotalWinnings(getCount(rank));
        }
        return sum;
    }
}
