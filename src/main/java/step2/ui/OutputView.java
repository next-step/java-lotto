package step2.ui;

import java.util.Map;

import step2.domain.Lotto;
import step2.domain.LottoRank;
import step2.domain.LottoStatistics;
import step2.domain.Lottos;
import step2.domain.WinningLotto;

public class OutputView {

    public static void printBuyLotto(final int userPickCount, final Lottos lottos) {
        System.out.printf("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", userPickCount, lottos.size() - userPickCount);
        printLottos(lottos);
    }

    public static void printLottoStatistics(WinningLotto winningLotto, LottoStatistics lottoStatistics) {
        System.out.println("\n당첨 통계\n---------");

        Map<LottoRank, Long> groupByRanks = lottoStatistics.groupingByRank(winningLotto);

        for (LottoRank rank : LottoRank.values()) {
            if (rank.getRank() < LottoRank.NO_RANK.getRank()) {
                System.out.println(rank.getEtc() + " - " + groupByRanks.getOrDefault(rank, 0L) + "개");
            }
        }

        System.out.printf("총 수익률은 %.2f 입니다.", lottoStatistics.getBenefitPercent(winningLotto));
    }

    private static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
    }
}
