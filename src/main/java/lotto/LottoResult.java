package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final int amount;
    private final Map<LottoRank, Integer> rankRecord = new HashMap<>();

    public LottoResult(int amount) {
        this.amount = amount;
        Arrays.stream(LottoRank.values()).forEach(rank -> rankRecord.put(rank, 0));
    }

    public void record(LottoRank rank) {
        int curCount = rankRecord.get(rank);
        rankRecord.put(rank, curCount + 1);
    }

    public String toStringRankResult(LottoRank rank) {
        if (rank == LottoRank.NONE) return "";
        return rank.getMatchCount() + "개 일치" +
                " (" + rank.getMatchReward() + "원)" +
                "- " + rankRecord.get(rank) + "개";
    }

    public Double profitRate() {
        double profit = 0.0;
        for (Map.Entry<LottoRank, Integer> entry : rankRecord.entrySet()) {
            profit += entry.getKey().getMatchReward() * entry.getValue();
        }
        return profit / amount;
    }
}
