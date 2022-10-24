package view;

import domain.Lotto;
import domain.LottoStatistics;
import domain.Rank;
import util.View;

import java.util.List;

public class ResultView {

    public static void printLottos(List<Lotto> lottos) {
        View.outputView.printf("%d개를 구매했습니다.", lottos.size());
        View.outputView.println();
        lottos.stream()
                .forEach(lotto -> System.out.println(lotto));
    }

    public static void printStatistics(LottoStatistics lottoStatistics) {
        View.outputView.println("당첨 통계");
        View.outputView.println("---------");
        List<Rank> ranks = List.of(Rank.FOUR, Rank.THREE, Rank.TWO, Rank.ONE);
        for (Rank rank : ranks) {
            View.outputView.printf(
                    "%d개 일치 (%d원)- %d개"
                    , rank.getEqualCount()
                    , rank.getWinningPrice()
                    , lottoStatistics.matchRank(rank)
            );
        }

        View.outputView.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", lottoStatistics.calculateEfficiency(), lottoStatistics.calculateEfficiency() > 1 ? "이득" : "손해");
    }
}
