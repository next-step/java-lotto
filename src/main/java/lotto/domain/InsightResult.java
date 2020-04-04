package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class InsightResult {
    private final Map<RankEnum, Integer> insightResult;

    public InsightResult(Map<RankEnum, Integer> results) {
        this.insightResult = Collections.unmodifiableMap(results);
    }

    public Map<RankEnum, Integer> getInsightResult() {
        return new HashMap<>(this.insightResult);
    }

    public int getTotalRevenue() {
        int totalRevenue = 0;
        for (RankEnum rank : insightResult.keySet()) {
            totalRevenue += rank.getReward() * insightResult.get(rank);
        }
        return totalRevenue;
    }
}
