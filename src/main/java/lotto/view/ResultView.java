package lotto.view;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.Statistic;

public class ResultView {

    public static void showLottos(Lottos lottos) {
        System.out.println("수동으로 " + lottos.getManualLottos().size() + "장, 자동으로 " + lottos.getAutoLottos().size() + "장을 구매했습니다.");
        for (Lotto lotto : lottos.getManualLottos()) {
            System.out.println(lotto.lottoNumbers());
        }
        for (Lotto lotto : lottos.getAutoLottos()) {
            System.out.println(lotto.lottoNumbers());
        }

    }

    public static void showStatistics(Statistic stat) {
        System.out.println("\n당첨 통계\n---------");
        Map<Rank, Integer> resultMap = stat.result();

        for (Rank rank : Rank.values()) {
            if (rank.getCountOfMatch() < 3) {
                continue; // 3개 미만은 통계에 포함하지 않음
            }

            int count = resultMap.getOrDefault(rank, 0);
            int prize = rank.getWinningMoney();

            System.out.printf("%d개 일치", rank.getCountOfMatch());
            if (rank == Rank.SECOND) {
                System.out.print(", 보너스 볼 일치");
            }
            System.out.printf(" (%d원) - %d개\n", prize, count);
        }

        double rate = stat.getProfitRate();
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s)\n",
            rate, rate < 1 ? "손해라는 의미임" : "이득이라는 의미임");
    }
}
