package lotto.dto;

import lotto.domain.Rank;

import java.util.Map;

/**
 * @author han
 */
public class StatisticResult {
    private final Map<Rank, Long> rankIntegerMap;
    private final String profit;

    public StatisticResult(Map<Rank, Long> result, String profit) {
        this.rankIntegerMap = result;
        this.profit = profit;
    }

    public Map<Rank, Long> getRankIntegerMap() {
        return rankIntegerMap;
    }

    public String getProfit() {
        return profit;
    }
}
