package lottos.controller;

import lottos.domain.Lotto;
import lottos.domain.LottoResult;
import lottos.domain.Lottos;
import lottos.domain.Statistics;


public class ConsoleOutputView {

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getElements()) {
            System.out.println(lotto.getElements());
        }
        System.out.println();
    }

    public void printStatistics(Statistics statistics) {

        double prizeTotal = 0;

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("----------");

        for (LottoResult lottoResult : statistics.getLottoResults()) {
            final int nameOfMatches = lottoResult.getResult().getNameOfMatches();
            final int countOfMatches = lottoResult.getResult().getCountOfMatches();
            final int prize = lottoResult.getPrize();
            if (nameOfMatches >= 3) {
                System.out.printf("%d개 일치 (%d원) - %d개%n", nameOfMatches, prize, countOfMatches);
                prizeTotal += prize * countOfMatches;
            }
        }

        double yield = prizeTotal / statistics.getPurchaseAmount();
        System.out.printf("수익률은 %.2f입니다.", yield);
    }
}
