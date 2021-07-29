package lotto.view;

import lotto.domain.*;

import java.util.Map;

import static lotto.domain.LottoMatchType.*;

public class ResultView {

    private static final LottoStatistics statistics = new LottoStatistics();

    private ResultView() {
    }

    public static void printBuyTicket(Lottos lottoTickets) {
        lottoTickets.getLottos().forEach(System.out::println);
    }

    public static void printStatistics(Lottos buyLotto, WinningLotto winningLotto) {
        statistics.summary(buyLotto, winningLotto);
        System.out.println("당첨 통계");
        System.out.println("---------");

        Map<LottoMatchType, Integer> statisticsMap = statistics.getStatisticsMap();
        for (LottoMatchType type : values()) {
            Integer matchCount = getMatchCount(statisticsMap.get(type));
            System.out.println(type.getMatchCount() + "개 일치" + description(type) + "(" + type.getWinMoney() + "원)" + "- " + matchCount + "개");
        }
        profitPrint(statistics.profitRate(buyLotto));
    }

    private static String description(LottoMatchType type) {
        if(type == SECOND) {
            return ", 보너스 볼 일치";
        }
        return "";
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
