package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class PrizeSummary {
    private final Map<Rank, Integer> prizeSummary;

    public PrizeSummary(Map<Rank, Integer> prizeSummary) {
        this.prizeSummary = prizeSummary;
    }

    public int calculatePrizeAmount() {
        return prizeSummary.entrySet().stream()
                .mapToInt(prizeDetail -> prizeDetail.getKey().calculateRankByCount(prizeDetail.getValue()))
                .sum();
    }

    public Map<Rank, Integer> getPrizeSummary() {
        return Collections.unmodifiableMap(prizeSummary);
    }
}
