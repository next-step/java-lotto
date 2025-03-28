package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Statistic;

public class ResultView {

    public static void showLottos(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.lottoNumbers());
        }
    }

    public static void showStatistics(Statistic stat, int paidMoney) {
        System.out.println("\n당첨 통계\n---------");
        for (int i = 3; i <= 6; i++) {
            int count = stat.getMatchCountMap().getOrDefault(i, 0);
            int prize = Statistic.PRIZE_MAP.get(i);
            System.out.printf("%d개 일치 (%d원)- %d개\n", i, prize, count);
        }

        double rate = stat.getProfitRate(paidMoney);

        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s)\n",
            rate, rate < 1 ? "손해라는 의미임" : "이득이라는 의미임");
    }
}
