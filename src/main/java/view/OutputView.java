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

    public static Map<Integer, Integer> printWinningInfo(LottoGames lottoGames) {
        Map<Integer, Integer> winningStatistics = lottoGames.getWinningStatistics();
        System.out.println();
        for (int i = 3; i <= 6; i++) {
            System.out.printf("%d개 일치 (%d원) - %d개\n", i, LottoGames.winningMoneyMap.getWinningMoney(i), winningStatistics.get(i));
        }
        return winningStatistics;
    }

    public static void printBenefitRate(LottoGames lottoGames, Map<Integer, Integer> gameStatistics) {
        double benefitRate = lottoGames.getBenefitRate(gameStatistics);
        System.out.println("=========");
        System.out.printf("총 수익률 : %.2f\n", benefitRate);
    }
}
