package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private final Map<Integer, LottoRanking> rankingByCountMap;
    private Lotto winningLotto;

    public LottoGame() {
        rankingByCountMap = new HashMap<>();
        for (LottoRanking lottoRanking : LottoRanking.values()) {
            rankingByCountMap.put(lottoRanking.getMatchCount(), lottoRanking);
        }
    }

    public void setWinningLotto(Lotto lotto) {
        winningLotto = lotto;
    }

    public LottoResult match(List<Lotto> lottos) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            int countOfMatch = winningLotto.getCountOfMatch(lotto);
            addRankingToResult(lottoResult, countOfMatch);
        }
        return lottoResult;
    }

    private void addRankingToResult(LottoResult lottoResult, int countOfMatch) {
        LottoRanking lottoRanking = rankingByCountMap.get(countOfMatch);
        if (lottoRanking != null) {
            lottoResult.addRanking(lottoRanking);
        }
    }
}
