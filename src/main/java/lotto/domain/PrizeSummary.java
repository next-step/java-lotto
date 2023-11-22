package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class PrizeSummary {
    private final Map<Prize, Integer> prizeSummary;

    public PrizeSummary(Map<Prize, Integer> prizeSummary) {
        this.prizeSummary = prizeSummary;
    }

    public int calculatePrizeAmount() {
        return prizeSummary.entrySet().stream()
                .mapToInt(prizeDetail -> prizeDetail.getKey().calculatePrizeByCount(prizeDetail.getValue()))
                .sum();
    }

    public Map<Prize, Integer> getPrizeSummary() {
        return Collections.unmodifiableMap(prizeSummary);
    }
}
