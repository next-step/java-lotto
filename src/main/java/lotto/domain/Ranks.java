package lotto.domain;

import lotto.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ranks {
    private List<Rank> ranks;
    private Insights insights;

    public Ranks(List<Rank> ranks) {
        this.ranks = ranks;
        this.insights = new Insights();
    }

    public Map<Rank, Integer> updateLottoRank() {
        Map<Rank, Integer> lottoInsights = insights.getInsights();
        for (Rank lottoRank : ranks) {
            lottoInsights = insights.updateInsightsLottoRank(lottoRank);
        }
        return lottoInsights;
    }

    public int getTotalLottoWinningPrice() {
        int sum = 0;
        for (Rank rank : ranks) {
            sum += insights.getWinningMoney(rank);
        }
        return sum;
    }

    public List<Rank> getRanks() {
        return new ArrayList<>(this.ranks);
    }
}
