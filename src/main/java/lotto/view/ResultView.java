package lotto.view;

import lotto.controller.LottoGame;
import lotto.model.MatchingResult;
import lotto.model.MyLottos;

import java.util.List;

public class ResultView {
    public static void printMyLottos(LottoGame lottoGame) {
        printBlankLine();
        System.out.println(lottoGame.findHowManyMyLottos() + "개를 구매했습니다.");

        lottoGame.getMyLottos().getLottoNumbers().stream()
                .forEach(it -> System.out.println(it.toString()));
        printBlankLine();
    }

    public static void printResult(LottoGame lottoGame, List<Integer> winningLotto, int bonusBall) {
        printBlankLine();
        printBlankLine();

        printStatistics(lottoGame.getMyLottos(), winningLotto, bonusBall);
        printEarningRate(lottoGame.getMyLottos(), winningLotto, bonusBall);
    }

    private static void printStatistics(MyLottos myLottos, List<Integer> winningLotto, int bonusBall) {
        System.out.println("당첨 통계");
        System.out.println("=========================================");

        for (MatchingResult matchingResult : MatchingResult.values()) {
            printStatistic(myLottos, winningLotto, matchingResult, bonusBall);
        }
    }

    private static void printStatistic(MyLottos myLottos, List<Integer> winningLotto,
                                       MatchingResult matchingResult, int bonusBall) {
        printStatisticsExceptSecond(myLottos, winningLotto, matchingResult, bonusBall);
        printStatisticForSecond(myLottos, winningLotto, matchingResult, bonusBall);

    }

    private static void printStatisticsExceptSecond(MyLottos myLottos, List<Integer> winningLotto,
                                                    MatchingResult matchingResult, int bonusBall) {
        if (!matchingResult.equals(MatchingResult.SECOND)){
            System.out.print(matchingResult.getMatchCount() + "개 일치 (" + matchingResult.getCashPrize() + "원) : ");
            System.out.println(myLottos.findCountOfNumMatching(winningLotto, matchingResult, bonusBall) + "개");
        }
    }

    private static void printStatisticForSecond(MyLottos myLottos, List<Integer> winningLotto,
                                                MatchingResult matchingResult, int bonusBall){
        if (matchingResult.equals(MatchingResult.SECOND)){
            System.out.print(matchingResult.getMatchCount() + "개 일치, 보너스볼 일치(" + matchingResult.getCashPrize() + "원) : ");
            System.out.println(myLottos.findCountOfNumMatching(winningLotto, matchingResult, bonusBall) + "개");
        }
    }

    private static void printEarningRate(MyLottos myLottos, List<Integer> winningLotto, int bonusBall) {
        double earningRate = myLottos.calculateEarningRate(winningLotto, bonusBall);
        System.out.println("총 수익률은 " + String.format("%.2f", earningRate) + "%입니다.");
    }

    private static void printBlankLine() {
        System.out.println();
    }
}