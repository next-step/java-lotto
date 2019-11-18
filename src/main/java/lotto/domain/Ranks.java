package lotto.domain;

import lotto.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ranks {

    private List<Rank> ranks;
    private Insights insights;
    private WinningRank winningRank;

    public Ranks(WinningRank winningRank, Lottos lottos) {
        this.insights = new Insights();
        this.winningRank = winningRank;
        this.ranks = getWinningLottoRanks(lottos);
    }

    private List<Rank> getWinningLottoRanks(Lottos lottos) {
        this.ranks = new ArrayList<>();
        List<Lotto> purchasedLottos = lottos.getLottos();
        for (Lotto lotto : purchasedLottos) {
            int winNumberCount = winningRank.checkWinNumber(lotto);
            ranks.add(winningRank.getRankByWinner(winNumberCount, winningRank.getHitCount(lotto)));
        }
        return ranks;
    }

    public Map<Rank, Integer> updateLottoRank() {
        Map<Rank, Integer> lottoInsights = insights.getInsights();
        for (Rank lottoRank : this.ranks) {
            lottoInsights = insights.updateInsightsLottoRank(lottoRank);
        }
        return lottoInsights;
    }

    public int getTotalLottoWinningPrice() {
        return insights.getWinningMoney(this.getRanks());
    }

    public List<Rank> getRanks() {
        return new ArrayList<>(this.ranks);
    }
}
