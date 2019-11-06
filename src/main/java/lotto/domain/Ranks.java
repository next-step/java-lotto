package lotto.domain;

import lotto.Rank;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ranks {
    private final static int COUNT_ADD_NUMBER = 1;
    private List<Rank> ranks;
    private Map<Rank, Integer> insights;

    public Ranks(List<Rank> ranks) {
        this.ranks = ranks;
        this.insights = createInsights();
    }

    public Map<Rank, Integer> getLottoRankCount() {
        for (Rank rank : this.ranks) {
            putInsights(rank);
        }
        return insights;
    }

    public int getTotalLottoWinningPrice() {
        int sum = 0;
        for (Map.Entry<Rank, Integer> entry : insights.entrySet()) {
            sum += addLottoWinningPrice(entry);
        }
        return sum;
    }

    private int addLottoWinningPrice(Map.Entry<Rank, Integer> entry) {
        return entry.getKey().getWinningMoney() * entry.getValue();
    }

    private void putInsights(Rank rank) {
        if (insights.containsKey(rank)) {
            insights.put(rank, insights.get(rank) + COUNT_ADD_NUMBER);
        }
    }

    private Map<Rank, Integer> createInsights() {
        Map<Rank, Integer> insights = new LinkedHashMap<>();
        insights.put(Rank.FIFTH, 0);
        insights.put(Rank.FOURTH, 0);
        insights.put(Rank.THIRD, 0);
        insights.put(Rank.SECOND, 0);
        insights.put(Rank.FIRST, 0);
        return insights;
    }

    public List<Rank> getRanks() {
        return ranks;
    }
}
