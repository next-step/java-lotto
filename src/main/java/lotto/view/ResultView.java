package lotto.view;

import lotto.domain.BonusNumberMatchCondition;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

public class ResultView {
    private ResultView() {
    }

    public static void printLottoNumber(LottoNumbers lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printStat(double rateOfReturn, LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoRank lottoRank : LottoRank.values()) {
            printLottoRankStatWhenLottoRankIsNotETC(lottoRank, lottoResult);
        }

        System.out.printf("총 수익률은 %.2f입니다.\n", rateOfReturn);
    }

    private static void printLottoRankStatWhenLottoRankIsNotETC(LottoRank lottoRank, LottoResult lottoResult) {
        if (lottoRank == LottoRank.ETC)
            return;

        String additionalStr = lottoRank.getBonusNumberMatchCondition() == BonusNumberMatchCondition.MATCH ? ", 보너스 볼 일치" : "";
        System.out.printf("%d개 일치%s (%d원)- %d개\n", lottoRank.getMatchCount(), additionalStr, lottoRank.getMoney(), lottoResult.lottoResult(lottoRank));
    }
}
