package lotto.view;

import lotto.controller.LottoGame;
import lotto.model.Result;
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

        for (Result result : Result.values()) {
            printStatistic(myLottos, winningLotto, result, bonusBall);
        }
    }

    private static void printStatistic(MyLottos myLottos, List<Integer> winningLotto,
                                       Result result, int bonusBall) {
        printStatisticsExceptSecond(myLottos, winningLotto, result, bonusBall);
        printStatisticForSecond(myLottos, winningLotto, result, bonusBall);

    }

    private static void printStatisticsExceptSecond(MyLottos myLottos, List<Integer> winningLotto,
                                                    Result result, int bonusBall) {
        if (!result.equals(Result.SECOND)){
            System.out.print(result.getMatchCount() + "개 일치 (" + result.getCashPrize() + "원) : ");
            System.out.println(myLottos.findCountOfNumMatching(winningLotto, result, bonusBall) + "개");
        }
    }

    private static void printStatisticForSecond(MyLottos myLottos, List<Integer> winningLotto,
                                                Result result, int bonusBall){
        if (result.equals(Result.SECOND)){
            System.out.print(result.getMatchCount() + "개 일치, 보너스볼 일치(" + result.getCashPrize() + "원) : ");
            System.out.println(myLottos.findCountOfNumMatching(winningLotto, result, bonusBall) + "개");
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