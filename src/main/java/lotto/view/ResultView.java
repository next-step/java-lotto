package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Prize;

public class ResultView {

    public static void printLottoCounts(final int lottoCounts) {
        System.out.println(lottoCounts + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }

        System.out.println();
    }

    public static void printWinningStatistics(Map<Integer, List<Lotto>> winningResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (int i = Prize.FOURTH.getHavingCounts(); i <= Prize.FIRST.getHavingCounts(); i++) {
            StringBuilder statisticsBuilder = new StringBuilder();

            statisticsBuilder.append(i).append("개 일치 (")
                .append(Prize.havingCountsOf(i).getMoney()).append("원)-")
                .append(winningResult.get(i).size()).append("개");

            System.out.println(statisticsBuilder);
        }

        System.out.println();
    }

    public static void printEarningsRate(double earningsRate) {
        System.out.printf("총 수익률은 %.2f입니다", earningsRate);

        if (earningsRate < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
