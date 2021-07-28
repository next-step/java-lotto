package lotto.view;

import lotto.domain.*;

import java.util.Map;

public class ResultView {

    private static final LottoStatistics statistics = new LottoStatistics();

    private ResultView() {
    }

    public static void printBuyTicket(Lottos lottoTickets) {
        lottoTickets.getLottos().forEach(System.out::println);
    }

    public static void printStatistics(Lottos buyLotto, LottoBonus lottoBonus) {
        statistics.summary(buyLotto, lottoBonus);
        System.out.println("당첨 통계");
        System.out.println("---------");

        Map<LottoMatchType, Integer> statisticsMap = statistics.getStatisticsMap();
        for (LottoMatchType type : LottoMatchType.values()) {
            Integer matchCount = getMatchCount(statisticsMap.get(type));
            System.out.println(type.getMatchCount() + "개 일치 (" + type.getWinMoney() + "원)" + "- " + matchCount + "개");
        }
        profitPrint(statistics.profitRate(buyLotto));
    }

    private static Integer getMatchCount(Integer count) {
        if (count == null) {
            return 0;
        }
        return count;
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
