package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningType;

import java.util.List;

public class ResultView {


    public void printLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + lottoResult.matchLottoCount(WinningType.MATCH_COUNT_THREE));
        System.out.println("4개 일치 (50000원) - " + lottoResult.matchLottoCount(WinningType.MATCH_COUNT_FOUR));
        System.out.println("5개 일치 (1500000원) - " + lottoResult.matchLottoCount(WinningType.MATCH_COUNT_FIVE));
        System.out.println("6개 일치 (2000000000원) - " + lottoResult.matchLottoCount(WinningType.MATCH_COUNT_SIX));

    }

    public void printEarningsRate(double earningsRate) {
        System.out.println("총 수익률은 " + earningsRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
