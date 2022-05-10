package lotto.model;

import java.util.Map;

public class LottoResult {
    private final Map<Rank, Long> rankMap;

    public LottoResult(Map<Rank, Long> rankMap) {
        this.rankMap = rankMap;
    }

    public int getResult(int coincidence) {
        Rank rank = Rank.of(coincidence);
        if(rankMap.get(rank) == null){
            return 0;
        }
        return rankMap.get(rank).intValue();
    }


    public double getProfitRate(Money buy) {
        Money profit = new Money();
        for (Map.Entry<Rank, Long> entry: rankMap.entrySet()){
            int cnt = entry.getValue().intValue();
            Money reward = entry.getKey().getReward();
            profit = profit.add(reward.multiply(cnt));
        }
        return profit.divide(buy);
    }
}
