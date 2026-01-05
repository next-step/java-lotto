package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;

public class OutputView {

    public static void printLotto(Lottos lottoList, int manualCount) {
        int autoCount = lottoList.size() - manualCount;
        System.out.println("수동으로 " + manualCount + "장, 자동으로 " + autoCount + "개를 구매했습니다.");

        for (var lotto : lottoList.lottos()) {
            System.out.println(lotto.toString());
        }
    }

    public static void printWinningStatistics(LottoStatistics statistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoRank rank : LottoRank.values()) {
            if (rank.isNoRank()) {
                continue;
            }
            int count = statistics.getCount(rank);

            if (rank == LottoRank.SECOND) {
                System.out.println("5개 일치, 보너스 볼 일치(" + rank.prizeMoney() + "원) - " + count + "개");
                continue;
            }
            System.out.println(rank.matchCount() + "개 일치 (" + rank.prizeMoney() + "원) - " + count + "개");
        }
    }

    public static void printYield(float yield) {
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n", yield);
    }
}
