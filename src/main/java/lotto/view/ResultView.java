package lotto.view;

import lotto.domain.*;

import static lotto.domain.Rank.MISS;

public class ResultView {

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.of()) {
            System.out.println(lotto.getLotto());
        }
    }

    public void printResult(Results results, double profit) {
        System.out.println("당첨 통계");
        System.out.println("-----------------");

        for (Rank Rank : Rank.values()) {
            if (Rank == MISS) {
                continue;
            }
            printRank(Rank, results);
        }
        printProfit(profit);
    }

    private void printRank(Rank Rank, Results results) {
        System.out.printf("%s개 일치 (%s원)- %s개\n",
                Rank.getCountOfMatch(),
                Rank.getWinningMoney(),
                results.of().getOrDefault(Rank, 0));
    }

    private void printProfit(double profit) {
        System.out.printf("총 수익률은 %.2f입니다.\n", profit);
    }
}
