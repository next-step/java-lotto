package view;

import domain.LottoGame;
import domain.LottoGames;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printLottoGames(List<LottoGame> lottoGameList) {
        for (LottoGame lottoGame : lottoGameList) {
            System.out.println(lottoGame.getNumbers());
        }
    }

    public static void printWinningInfo(Map<Integer, Integer> winningStatistics) {
        System.out.println();
        for (int i = 3; i <= 6; i++) {
            System.out.printf("%d개 일치 (%d원) - %d개\n", i, LottoGames.winningMoneyMap.get(i), winningStatistics.get(i));
        }
    }

    public static void printBenefitRate(double benefitRate) {
        System.out.println("=========");
        System.out.printf("총 수익률 : %.2f\n", benefitRate);
    }
}
