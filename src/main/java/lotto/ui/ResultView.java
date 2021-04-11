package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.Statistics;

import java.text.DecimalFormat;
import java.util.List;

public class ResultView {
    private final static DecimalFormat form = new DecimalFormat("#.##");
    private final static String PRINT_STATISTICS_START = "당첨 통계\n---------";


    public static void printPurchaseLotto(Lottos lottos, List<Lotto> manualLottos) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다."
                , manualLottos.size()
                , lottos.size() - manualLottos.size()));
        lottos.stream()
                .forEach(lotto -> System.out.println(lotto.toString()));
    }

    public static void printStatistics(Statistics statistics) {
        System.out.println(PRINT_STATISTICS_START);
        statistics.getStatistics()
                .keySet()
                .stream()
                .filter(rank -> rank != Rank.OTHER)
                .forEach(rank -> printStatistic(rank, statistics));
    }

    private static void printStatistic(Rank rank, Statistics statistics) {
        if (rank.equals(Rank.SECOND)) {
            System.out.println(String.format("%d개 일치, 보너스 볼 일치(%d원)- %d개"
                    , rank.getMatchCount()
                    , rank.getWinningMoney()
                    , statistics.getStatistics().get(rank)));
        }

        if (!rank.equals(Rank.SECOND)) {
            System.out.println(String.format("%d개 일치 (%d원)- %d개"
                    , rank.getMatchCount()
                    , rank.getWinningMoney()
                    , statistics.getStatistics().get(rank)));
        }
    }

    public static void printYield(Statistics statistics, int purchaseAmount) {
        double yield = statistics.yield(purchaseAmount);
        if (yield > 1) {
            System.out.println("총 수익률은 " + form.format(statistics.yield(purchaseAmount)) + "입니다.");
        }
        if (yield <= 1) {
            System.out.println("총 수익률은 " + form.format(statistics.yield(purchaseAmount)) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
