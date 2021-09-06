package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final int amount;
    private final Map<LottoRank, Integer> rankRecord = new HashMap<>();

    public LottoResult(int amount) {
        this.amount = amount;
        LottoRank.ranks().forEach(rank -> rankRecord.put(rank, 0));
    }

    public void record(LottoRank rank) {
        int curCount = rankRecord.get(rank);
        rankRecord.put(rank, curCount + 1);
    }

    public int winningCount(LottoRank rank) {
        return rankRecord.get(rank);
    }

    public Double profitRate() {
        double profit = 0.0;
        for (Map.Entry<LottoRank, Integer> entry : rankRecord.entrySet()) {
            profit += entry.getKey().getMatchReward() * entry.getValue();
        }
        return profit / amount;
    }
}
