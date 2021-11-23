package lotto.dto;

import lotto.domain.Rank;

import java.util.Map;

/**
 * @author han
 */
public class StatisticsResult {
    private final Map<Rank, Integer> rankIntegerMap;
    private final String profit;

    public StatisticsResult(Map<Rank, Integer> result, String profit) {
        this.rankIntegerMap = result;
        this.profit = profit;
    }

    public Map<Rank, Integer> getRankIntegerMap() {
        return rankIntegerMap;
    }

    public String getProfit() {
        return profit;
    }
}
