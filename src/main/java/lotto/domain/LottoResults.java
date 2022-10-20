package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResults {

    private Map<Rank, Integer> lottoResults;

    public LottoResults() {
        this.lottoResults = new HashMap<>();
    }

    public void addRank(Rank rank) {
        int count = lottoResults.getOrDefault(rank, 0);
        lottoResults.put(rank, count + 1);
    }
    public double getProfitRate(int totalLottoCnt) {
        int countSum = 0;
        for (Rank rank : lottoResults.keySet()) {
            countSum += rank == Rank.MISS ? 0 : lottoResults.get(rank);
        }
        return (double) countSum / totalLottoCnt;
    }

    public int getRankCount(Rank rank) {
        if (!lottoResults.containsKey(rank)) {
            return 0;
        }
        return lottoResults.get(rank);
    }

    public LottoResults getTotalResults(LottoGame lottoGame) {
        getResults(lottoGame.getManualLottos(), lottoGame.getWinningLotto());
        getResults(lottoGame.getAutoLottos(), lottoGame.getWinningLotto());

        return this;
    }

    private void getResults(Lottos lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos.getLottos()) {
            int sameNumbers = lotto.getSameNumberCount(winningLotto.getWinningLotto());
            boolean winBonus = lotto.getLottoNumbers().contains(winningLotto.getBonusNumber());

            Rank rank = Rank.valueOf(sameNumbers, winBonus);
            int count = lottoResults.getOrDefault(rank, 0);
            lottoResults.put(rank, count + 1);
        }
    }
}
