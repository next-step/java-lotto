package lotto.step2.result;

import lotto.step2.domain.Lotto;
import lotto.step2.domain.LottoResults;

import java.util.List;

public class ResultView {
    private ResultView() {
        throw new IllegalStateException("Utility class");
    }

    public static void printLottos(List<Lotto> lottos, final int passiveLottoCount) {
        int autoLottoCount = lottos.size() - passiveLottoCount;

        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n",
                passiveLottoCount, autoLottoCount);

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }

        System.out.println();
    }

    public static void printLottoResults(final LottoResults lottoResults) {
        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println(lottoResults.toString());
    }

    public static void printRateOfReturn(final double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "입니다. (본전 기준은 1입니다.)");
    }
}
