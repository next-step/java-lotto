package lotto.domain;

import lotto.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ranks {
    private static final int BONUS_CHECK = 1;
    private static final int SECOND_LOTTO_WIN_COUNT = 5;

    private List<Rank> ranks;
    private Insights insights;
    private int[] winLotto;
    private int bonusNumber;

    public Ranks(int[] winLotto, int bonusNumber) {
        this.insights = new Insights();
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Rank> getWinningLottoRanks(Lottos lottos) {
        this.ranks = new ArrayList<>();
        List<Lotto> purchasedLottos = lottos.getLottos();
        for (Lotto lotto : purchasedLottos) {
            int winNumberCount = lotto.checkWinNumber(winLotto);
            ranks.add(getRankByWinner(winNumberCount, lotto.getHitCount(bonusNumber)));
        }
        return ranks;
    }

    private Rank getRankByWinner(int winNumberCount, int bonusNumber) {
        if (winNumberCount == SECOND_LOTTO_WIN_COUNT) {
            return getRankBySecondOrThirdOfWinner(winNumberCount, bonusNumber);
        }
        return Rank.valueOf(winNumberCount, false);
    }

    private Rank getRankBySecondOrThirdOfWinner(int winNumberCount, int bonusNumber) {
        if (bonusNumber == BONUS_CHECK) {
            return Rank.valueOf(winNumberCount, true);
        }
        return Rank.valueOf(winNumberCount, true);
    }

    public Map<Rank, Integer> updateLottoRank() {
        Map<Rank, Integer> lottoInsights = insights.getInsights();
        for (Rank lottoRank : ranks) {
            lottoInsights = insights.updateInsightsLottoRank(lottoRank);
        }
        return lottoInsights;
    }

    public int getTotalLottoWinningPrice(List<Rank> ranks) {
        return insights.getWinningMoney(ranks);
    }

    public List<Rank> getRanks() {
        return new ArrayList<>(this.ranks);
    }
}
