package lotto.domain;

import java.util.List;

public class LottoGame {

    public static LottoResult match(Lotto winningLotto, LottoNumber bonusBall, List<Lotto> lottos) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            int countOfMatch = winningLotto.countOfMatch(lotto);
            addRankingToResult(lotto, lottoResult, countOfMatch, bonusBall);
        }
        return lottoResult;
    }

    private static void addRankingToResult(Lotto lotto,
                                           LottoResult lottoResult,
                                           int countOfMatch,
                                           LottoNumber bonusBall) {
        LottoRanking lottoRanking = LottoRanking.valueOf(countOfMatch);
        if (lottoRanking != null) {
            lottoRanking = checkBonusRanking(lotto, lottoRanking, bonusBall);
            lottoResult.addRanking(lottoRanking);
        }
    }

    private static LottoRanking checkBonusRanking(Lotto lotto,
                                                  LottoRanking ranking,
                                                  LottoNumber bonusBall) {
        return (ranking == LottoRanking.SECOND && lotto.contain(bonusBall))
            ? LottoRanking.BONUS
            : ranking;
    }

}
