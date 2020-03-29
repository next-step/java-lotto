package lotto.view;

import lotto.controller.LottoGame;
import lotto.model.MatchingResult;
import lotto.model.MyLottos;

import java.util.List;

import static lotto.model.MatchingResult.*;

public class ResultView {
    public static void printMyLottos(LottoGame lottoGame) {
        printBlankLine();
        printMyLottosTiTle(lottoGame);
        printMyLottosBody(lottoGame);
        printBlankLine();
    }

    private static void printMyLottosTiTle(LottoGame lottoGame) {
        System.out.println(lottoGame.getMyLottos().getLottoNumbers().size() + "개를 구매했습니다.");
    }

    private static void printMyLottosBody(LottoGame lottoGame) {
        lottoGame.getMyLottos().getLottoNumbers().stream()
                .forEach(it -> System.out.println(it.toString()));
    }

    public static void printResult(LottoGame lottoGame, List<Integer> winningLotto) {
        printBlankLine();
        printResultTitle();
        printStatistics(lottoGame.getMyLottos(), winningLotto);
        printEarningRate(lottoGame.getMyLottos(), winningLotto);
    }

    private static void printResultTitle() {
        printBlankLine();
        System.out.println("당첨 통계");
        System.out.println("=========================================");
    }

    private static void printStatistics(MyLottos myLottos, List<Integer> winningLotto) {
        printStatistic(myLottos, winningLotto, THREE);
        printStatistic(myLottos, winningLotto, FOUR);
        printStatistic(myLottos, winningLotto, FIVE);
        printStatistic(myLottos, winningLotto, SIX);
    }

    private static void printStatistic(MyLottos myLottos, List<Integer> winningLotto,
                                       MatchingResult matchingResult){
        System.out.print(matchingResult.getMatchCount() + "개 일치 (" + matchingResult.getCashPrize() + "원) : ");
        System.out.println(myLottos.findCountOfNumMatching(winningLotto, matchingResult) + "개");

    }

    private static void printEarningRate(MyLottos myLottos, List<Integer> winningLotto) {
        double earningRate = myLottos.calculateEarningRate(winningLotto);
        System.out.println("총 수익률은 " + String.format("%.2f", earningRate) + "%입니다.");
    }

    private static void printBlankLine() {
        System.out.println();
    }
}