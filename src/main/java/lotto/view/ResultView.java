package lotto.view;

import lotto.controller.LottoGame;
import lotto.model.MyLottos;
import lotto.model.Rank;
import lotto.model.winninglotto.WinningLotto;

public class ResultView {
    public static void printMyLottos(LottoGame lottoGame) {
        printBlankLine();
        System.out.println(lottoGame.findHowManyMyLottos() + "개를 구매했습니다.");

        lottoGame.getMyLottos().getLottoNumbers().stream()
                .forEach(it -> System.out.println(it.toString()));
        printBlankLine();
    }

    public static void printResult(LottoGame lottoGame, WinningLotto winningLotto) {
        printBlankLine();
        printBlankLine();

        printStatistics(lottoGame.getMyLottos(), winningLotto);
        printEarningRate(lottoGame.getMyLottos(), winningLotto);
    }

    private static void printStatistics(MyLottos myLottos, WinningLotto winningLotto) {
        System.out.println("당첨 통계");
        System.out.println("=========================================");

        for (Rank rank : Rank.values()) {
            printStatistic(myLottos, rank, winningLotto);
        }
    }

    private static void printStatistic(MyLottos myLottos, Rank rank, WinningLotto winningLotto) {
        printStatisticsExceptSecond(myLottos, rank, winningLotto);
        printStatisticForSecond(myLottos, rank, winningLotto);

    }

    private static void printStatisticsExceptSecond(MyLottos myLottos, Rank rank, WinningLotto winningLotto) {
        if (!rank.equals(Rank.SECOND)){
            System.out.print(rank.getMatchCount() + "개 일치 (" + rank.getCashPrize() + "원) : ");
            System.out.println(myLottos.findCountOfNumMatching(winningLotto, rank) + "개");
        }
    }

    private static void printStatisticForSecond(MyLottos myLottos, Rank rank, WinningLotto winningLotto){
        if (rank.equals(Rank.SECOND)){
            System.out.print(rank.getMatchCount() + "개 일치, 보너스볼 일치(" + rank.getCashPrize() + "원) : ");
            System.out.println(myLottos.findCountOfNumMatching(winningLotto, rank) + "개");
        }
    }

    private static void printEarningRate(MyLottos myLottos, WinningLotto winningLotto) {
        double earningRate = myLottos.calculateEarningRate(winningLotto);
        System.out.println("총 수익률은 " + String.format("%.2f", earningRate) + "%입니다.");
    }

    private static void printBlankLine() {
        System.out.println();
    }
}