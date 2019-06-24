package step2.ui;

import java.util.List;
import java.util.Map;

import step2.domain.Lotto;
import step2.domain.LottoRank;
import step2.domain.LottoStatistics;
import step2.domain.Lottos;
import step2.domain.WinningLotto;

public class OutputView {

    public static void printBuyLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
    }

    public static void printLottoStatistics(WinningLotto winningLotto, LottoStatistics lottoStatistics) {
        System.out.println("\n당첨 통계\n---------");
        Map<LottoRank, Lottos> rankListMap = lottoStatistics.getMyRanks(winningLotto);
        for (LottoRank rank : LottoRank.values()) {
            if (LottoRank.NO_RANK.equals(rank)) {
                continue;
            }
            System.out.println(rank.getEtc() + " - " + rankListMap.getOrDefault(rank, new Lottos(List.of())).size() + "개");
        }

        System.out.printf("총 수익률은 %.2f 입니다.", lottoStatistics.getBenefitPercent(winningLotto));
    }
}
