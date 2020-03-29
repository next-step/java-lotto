package lotto.view;

import lotto.controller.LottoGame;
import lotto.model.Rank;
import lotto.model.MyLottos;
import lotto.model.WinningLottoNumbers;

import java.util.List;

public class ResultView {
    public static void printMyLottos(LottoGame lottoGame) {
        printBlankLine();
        System.out.println(lottoGame.findHowManyMyLottos() + "개를 구매했습니다.");

        lottoGame.getMyLottos().getLottoNumbers().stream()
                .forEach(it -> System.out.println(it.toString()));
        printBlankLine();
    }

    public static void printResult(LottoGame lottoGame, WinningLottoNumbers winningLottoNumbers, int bonusBall) {
        printBlankLine();
        printBlankLine();

        printStatistics(lottoGame.getMyLottos(), winningLottoNumbers, bonusBall);
        printEarningRate(lottoGame.getMyLottos(), winningLottoNumbers, bonusBall);
    }

    private static void printStatistics(MyLottos myLottos, WinningLottoNumbers winningLottoNumbers, int bonusBall) {
        System.out.println("당첨 통계");
        System.out.println("=========================================");

        for (Rank rank : Rank.values()) {
            printStatistic(myLottos, winningLottoNumbers, rank, bonusBall);
        }
    }

    private static void printStatistic(MyLottos myLottos, WinningLottoNumbers winningLottoNumbers,
                                       Rank rank, int bonusBall) {
        printStatisticsExceptSecond(myLottos, winningLottoNumbers, rank, bonusBall);
        printStatisticForSecond(myLottos, winningLottoNumbers, rank, bonusBall);

    }

    private static void printStatisticsExceptSecond(MyLottos myLottos, WinningLottoNumbers winningLottoNumbers,
                                                    Rank rank, int bonusBall) {
        if (!rank.equals(Rank.SECOND)){
            System.out.print(rank.getMatchCount() + "개 일치 (" + rank.getCashPrize() + "원) : ");
            System.out.println(myLottos.findCountOfNumMatching(winningLottoNumbers, rank, bonusBall) + "개");
        }
    }

    private static void printStatisticForSecond(MyLottos myLottos, WinningLottoNumbers winningLottoNumbers,
                                                Rank rank, int bonusBall){
        if (rank.equals(Rank.SECOND)){
            System.out.print(rank.getMatchCount() + "개 일치, 보너스볼 일치(" + rank.getCashPrize() + "원) : ");
            System.out.println(myLottos.findCountOfNumMatching(winningLottoNumbers, rank, bonusBall) + "개");
        }
    }

    private static void printEarningRate(MyLottos myLottos, WinningLottoNumbers winningLottoNumbers, int bonusBall) {
        double earningRate = myLottos.calculateEarningRate(winningLottoNumbers, bonusBall);
        System.out.println("총 수익률은 " + String.format("%.2f", earningRate) + "%입니다.");
    }

    private static void printBlankLine() {
        System.out.println();
    }
}