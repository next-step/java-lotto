package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Statistics;

public class ResultView {

    public static void printLottos(Lottos lottos, int manualLottosConut) {
        System.out.println("수동으로 " + manualLottosConut + "장, 자동으로"
                + (lottos.count()-manualLottosConut) + "개를 구매했습니다.");
        for (Lotto lotto: lottos.getLottos()) {
            System.out.println("[" + lotto.getLottoToString() + "]");
        }
        System.out.println();
    }

    public static void printStatistics(Statistics statistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println(statistics.toStringtStatisticsMap());
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "입니다.");
    }
}
