package lotto.view;

import lotto.controller.LottoGame;
import lotto.model.MyLottos;

import java.util.List;

import static lotto.model.MatchingResult.*;

public class ResultView {
    private static int threeMatchLottos = 0;
    private static int fourMatchLottos = 0;
    private static int fiveMatchLottos = 0;
    private static int sixMatchLottos = 0;

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
        printMatchResults(lottoGame.getMyLottos(), winningLotto);
        printEarningRate(lottoGame.getMyLottos(), winningLotto);
    }

    private static void printResultTitle() {
        printBlankLine();
        System.out.println("당첨 통계");
        System.out.println("=========================================");
    }

    private static void printMatchResults(MyLottos myLottos, List<Integer> winningLotto) {
        findHowManyMatch(myLottos.findHowManyMatchWith(winningLotto));
        printStatistics();
    }

    private static void findHowManyMatch(List<Integer> matchCounts) {
        for (Integer integer : matchCounts) {
            addCount(integer);
        }
    }

    private static void addCount(int matchCount) {
        if (matchCount == 3) {
            threeMatchLottos++;
        }
        if (matchCount == 4) {
            fourMatchLottos++;
        }
        if (matchCount == 5) {
            fiveMatchLottos++;
        }
        if (matchCount == 6) {
            sixMatchLottos++;
        }
    }

    private static void printStatistics() {
        System.out.println(THREE.getMatchCount() + "개 일치 (" + THREE.getCashPrize() + "원) : " +
                threeMatchLottos + "개");
        System.out.println(FOUR.getMatchCount() + "개 일치 (" + FOUR.getCashPrize() + "원) : " +
                fourMatchLottos + "개");
        System.out.println(FIVE.getMatchCount() + "개 일치 (" + FIVE.getCashPrize() + "원) : " +
                fiveMatchLottos + "개");
        System.out.println(SIX.getMatchCount() + "개 일치 (" + SIX.getCashPrize() + "원) : " +
                sixMatchLottos + "개");
    }

    private static void printEarningRate(MyLottos myLottos, List<Integer> winningLotto) {
        double earningRate = myLottos.calculateEarningRate(winningLotto);
        System.out.println("총 수익률은 " + String.format("%.2f", earningRate) + "%입니다.");
    }

    private static void printBlankLine() {
        System.out.println();
    }
}