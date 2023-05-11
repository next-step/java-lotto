package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.RankType;

import java.util.Map;

public class ResultView {

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.count() + "개를 구매했습니다.");
        for (Lotto lotto: lottos.getLottos()) {
            System.out.println("[" + lotto.getLottoToString() + "]");
        }
        System.out.println();
    }

    public static void printStatistics(Map<RankType, Integer> statisticsMap) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        statisticsMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + "-" + entry.getValue() + "개"));
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "입니다.");
    }
}
