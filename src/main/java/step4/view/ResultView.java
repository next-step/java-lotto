package step4.view;

import step4.model.Lotto;
import step4.model.LottoResult;
import step4.model.Rank;

import java.util.List;

public class ResultView {
    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printResult(LottoResult lottoResult) {
        System.out.println("\n당첨 통계\n---------");
        for (Rank rank : Rank.values()) {
            printStatistics(rank, lottoResult);
        }
        System.out.printf("총 수익률은 %s입니다.\n", lottoResult.getProfit());
    }

    private void printStatistics(Rank rank, LottoResult lottoResult) {
        if (rank == Rank.MISS) {
            return;
        }

        if (rank.useBonusNo()) {
            System.out.printf("%d개 일치, 보너스 볼 일치(%s원)- %d개\n", rank.getMatchCount(), rank.getPrize(), lottoResult.getRankCount(rank));
            return;
        }

        System.out.printf("%d개 일치 (%s원)- %d개\n", rank.getMatchCount(), rank.getPrize(), lottoResult.getRankCount(rank));
    }
}
