package lotto.domain;

import lotto.Rank;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Insights {

    private final static int COUNT_ADD_NUMBER = 1;
    private final static int INITIAL_COUNT_VALUE = 0;
    private Map<Rank, Integer> insights;

    public Insights() {
        this.insights = createInsights();
    }

    private Map<Rank, Integer> createInsights() {
        Map<Rank, Integer> insights = new LinkedHashMap<>();
        insights.put(Rank.FIFTH, INITIAL_COUNT_VALUE);
        insights.put(Rank.FOURTH, INITIAL_COUNT_VALUE);
        insights.put(Rank.THIRD, INITIAL_COUNT_VALUE);
        insights.put(Rank.SECOND, INITIAL_COUNT_VALUE);
        insights.put(Rank.FIRST, INITIAL_COUNT_VALUE);
        insights.put(Rank.MISS, INITIAL_COUNT_VALUE);
        return insights;
    }

    public Map<Rank, Integer> updateInsightsLottoRank(Rank rank) {
        if (this.insights.containsKey(rank)) {
            insights.put(rank, updateRankCount(insights.get(rank)));
            return insights;
        }
        return insights;
    }

    private int updateRankCount(int currentRankCount) {
        return currentRankCount + COUNT_ADD_NUMBER;
    }

    public Map<Rank, Integer> getInsights() {
        return new LinkedHashMap<>(insights);
    }

    public int getWinningMoney(List<Rank> ranks) {
        int sum = 0;
        for (Rank rank : ranks) {
            sum += insights.get(rank) * rank.getWinningMoney();
        }
        return sum;
    }
}
