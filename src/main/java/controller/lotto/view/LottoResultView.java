package controller.lotto.view;

import controller.lotto.LottoStatistics;
import domain.common.Money;
import domain.lotto.Lotto;
import domain.lotto.LottoPrize;

import java.util.List;
import java.util.Map;

public class LottoResultView {

    public static void createUserLottoListView(List<Lotto> lottoList) {

        System.out.println(lottoList.size() + "개를 구매했습니다.");
        lottoList.stream()
                .forEach(item -> System.out.println(item));
    }

    public static void createStatisticsView(LottoStatistics lottoStatistics, Money money) {
        System.out.println("당첨 통계 \n ---------");
        Map<LottoPrize, Integer> prize = lottoStatistics.prize();
        prize.forEach((key, value) -> {
            System.out.println(key.getCountOfMatch() + "개 일치 (" + key.getWinningMoney() + ")- " + value + "개");
        });

        System.out.println("총 수익률은" + lottoStatistics.prizeStatistics(money) + "입니다.(기준이 1이기 때문에 결과적으로" + createStatisticsResult(lottoStatistics.prizeStatistics(money)) + "의미임)");
    }

    private static String createStatisticsResult(double prizeStatistics) {
        if (prizeStatistics > 1) {
            return "이득이라는";
        }
        if (prizeStatistics < 1) {
            return "손해라는";
        }
        return "본전이라는";
    }
}
