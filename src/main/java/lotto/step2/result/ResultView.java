package lotto.step2.result;

import lotto.step2.domain.Lotto;
import lotto.step2.domain.LottoResults;

import java.util.List;

public class ResultView {
    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printLottoResults(final LottoResults lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println(lottoResults.toString());
    }

    public static void printRateOfReturn(final double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "입니다. (본전 기준은 1입니다.)");
    }
}
