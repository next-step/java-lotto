package lotto.model;

import java.util.*;

public class LottoResult {
    private final Map<Rank, Long> rankMap;

    public LottoResult(Map<Rank, Long> rankMap) {
        this.rankMap = rankMap;
    }

    public Map<Rank, Long> getRankTreeMap(){
        Map<Rank, Long> res = new TreeMap<>(Collections.reverseOrder());
        for (Rank rank: Rank.values()) {
            if(rank.isWin()){
                res.put(rank, 0L);
            }
        }
        res.putAll(rankMap);
        return  res;
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
