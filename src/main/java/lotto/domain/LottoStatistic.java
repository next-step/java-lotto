package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistic {
    private static final int PURCHASE_UNIT = 1000;

    private int lottCount;
    private Map<Rank, Integer> rankCount = new HashMap<>();

    public LottoStatistic(List<Integer> matchCounts, LottoCount lottoCount) {
        lottCount = lottoCount.count();
        setRankCount(matchCounts);
    }

    public void setRankCount(List<Integer> matchCounts) {
        for (int count : matchCounts) {
            Rank rank = Rank.valueOfRank(count);
            rankCount.put(rank, rankCount.getOrDefault(rank,0) + 1);
        }
    }

    public Map<Rank, Integer> rankCount() {
        return Collections.unmodifiableMap(rankCount);
    }

    public double calculateProfitRate() {
        return getTotalReward() / (lottCount * PURCHASE_UNIT);
    }

    public int getTotalReward() {
        int total = 0;
        for (Rank rank : rankCount.keySet()) {
            total += rankCount.get(rank) * rank.getMoney();
        }
        return total;
    }

}
