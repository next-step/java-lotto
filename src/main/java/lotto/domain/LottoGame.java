package lotto.domain;

import java.util.List;

public class LottoGame {
    public static LottoResult match(Lotto winningLotto, List<Lotto> lottos) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            int countOfMatch = winningLotto.getCountOfMatch(lotto);
            addRankingToResult(lottoResult, countOfMatch);
        }
        return lottoResult;
    }

    private static void addRankingToResult(LottoResult lottoResult, int countOfMatch) {
        LottoRanking lottoRanking = LottoRanking.valueOfCount(countOfMatch);
        if (lottoRanking != null) {
            lottoResult.addRanking(lottoRanking);
        }
    }
}
