package lotto.domain;

import java.util.Map;

public class PrizeSummary {
    private final Map<Prize, Integer> prizeSummary;

    public PrizeSummary(Map<Prize, Integer> prizeSummary) {
        this.prizeSummary = prizeSummary;
    }

    public Map<Prize, Integer> getPrizeSummary() {
        return prizeSummary;
    }
}
