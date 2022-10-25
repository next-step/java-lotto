package view;

import domain.Lotto;
import domain.LottoStatistics;
import domain.Price;
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

    public static void printStatistics(Price purchasePrice, LottoStatistics lottoStatistics) {
        View.outputView.println("당첨 통계");
        View.outputView.println("---------");
        List<Rank> ranks = List.of(Rank.FIVE, Rank.FOUR, Rank.THREE, Rank.TWO, Rank.ONE);

        for (Rank rank : ranks) {
            View.outputView.printf(
                    getMessageFormat(rank)
                    , rank.getEqualCount()
                    , rank.getWinningPrice()
                    , lottoStatistics.matchRank(rank)
            );
        }

        double efficiency = lottoStatistics.calculateEfficiency(purchasePrice);
        View.outputView.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", efficiency, efficiency > 1 ? "이득" : "손해");
    }

    private static String getMessageFormat(Rank rank) {
        if (Rank.TWO == rank) {
            return "%d개 일치, 보너스 볼 일치 (%d원)- %d개";
        }

        return "%d개 일치 (%d원)- %d개";
    }
}
