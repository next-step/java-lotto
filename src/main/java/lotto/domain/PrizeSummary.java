package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class PrizeSummary {
    private final Map<Rank, Integer> prizeSummary;

    public PrizeSummary(Map<Rank, Integer> prizeSummary) {
        this.prizeSummary = prizeSummary;
    }

    public long calculatePrizeAmount() {
        return prizeSummary.entrySet().stream()
                .mapToLong(prizeDetail -> prizeDetail.getKey().calculateRankByCount(prizeDetail.getValue()))
                .sum();
    }

    public Map<Rank, Integer> getPrizeSummary() {
        return Collections.unmodifiableMap(prizeSummary);
    }
}
