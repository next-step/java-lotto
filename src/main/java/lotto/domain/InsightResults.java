package lotto.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class InsightResults {
    private final Map<RankEnum, Integer> insightResult;

    public InsightResults(Map<RankEnum, Integer> results) {
        this.insightResult = Collections.unmodifiableMap(new LinkedHashMap<>(results));
    }

    public Map<RankEnum, Integer> getInsightResult() {
        return new LinkedHashMap<>(this.insightResult);
    }

    public int getTotalRevenue() {
        int totalRevenue = 0;
        for (RankEnum rank : insightResult.keySet()) {
            totalRevenue += rank.getReward() * insightResult.get(rank);
        }
        return totalRevenue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsightResults that = (InsightResults) o;
        return Objects.equals(insightResult, that.insightResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(insightResult);
    }
}
