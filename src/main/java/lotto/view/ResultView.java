package lotto.view;

import lotto.domain.LottoMatchType;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoStatistics;

import java.util.List;
import java.util.Map;

public class ResultView {

    private ResultView() {
    }

    public static void printBuyTicket(List<LottoNumbers> lottoTickets) {
        lottoTickets.forEach(System.out::println);
    }

    public static void printStatistics(LottoStatistics statistics) {
        statistics.summary();
        System.out.println("당첨 통계");
        System.out.println("---------");

        Map<LottoMatchType, Integer> statisticsMap = statistics.getStatisticsMap();
        for (Map.Entry<LottoMatchType, Integer> set : statisticsMap.entrySet()) {
            LottoMatchType type = set.getKey();
            System.out.println(type.getMatchCount() + "개 일치 (" + type.getWinMoney() + "원)" + "- " + set.getValue() + "개");
        }

        profitPrint(statistics.profitRate());
    }

    private static void profitPrint(double profitRate) {
        System.out.printf("총 수익률은 %.2f 입니다. ", profitRate);
        if (profitRate < 1) {
            System.out.println("기준이 1이기 때문에 결과적으로 손해라는 의미임");
            return;
        }
        System.out.println("기준이 1이기 때문에 결과적으로 이득이라는 의미임");
    }
}
