package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Long> rankMap;

    public LottoResult() {
        rankMap = new HashMap<>();
        for (Rank rank: Rank.values()) {
            rankMap.put(rank, 0L);
        }
    }

    public void addCoincidenceCnt(int coincidence) {
        Rank rank = Rank.of(coincidence);
        rankMap.put(rank, rankMap.get(rank) + 1);
    }


    public int getResult(int coincidence) {
        Rank rank = Rank.of(coincidence);
        return rankMap.get(rank).intValue();
    }

    public double getProfitRate(int buy) {
        Money profit = new Money();
        for (Map.Entry<Rank, Long> entry: rankMap.entrySet()){
            int cnt = entry.getValue().intValue();
            Money reward = entry.getKey().getReward();
            profit = profit.add(reward.multiply(cnt));
        }
        return profit.getValue() / (double) buy;
    }
}
