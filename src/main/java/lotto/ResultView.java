package lotto;

import java.util.List;

public class ResultView {
    public static void printMyLottos(LottoGame lottoGame) {
        System.out.println();
        printMyLottosTiTle(lottoGame);
        printMyLottosBody(lottoGame);
        System.out.println();
    }

    private static void printMyLottosTiTle(LottoGame lottoGame) {
        System.out.println(lottoGame.getLottos().getLottos().size() + "개를 구매했습니다.");
    }

    private static void printMyLottosBody(LottoGame lottoGame) {
        lottoGame.getLottos().getLottos().stream()
                .forEach(it -> System.out.println(it.toString()));
    }

    public static void printResult(LottoGame lottoGame, List<Integer> winningLotto) {
        System.out.println();
        printResultTitle();
        printMatchResult(lottoGame, winningLotto);
        printMyEarningRate(lottoGame.getLottos(), winningLotto);
    }

    private static void printMatchResult(LottoGame lottoGame, List<Integer> winningLotto) {
        System.out.println();
        printThreeMatchResult(lottoGame.getLottos(), winningLotto);
        printFourMatchResult(lottoGame.getLottos(), winningLotto);
        printFiveMatchResult(lottoGame.getLottos(), winningLotto);
        printSixMatchResult(lottoGame.getLottos(), winningLotto);
    }

    private static void printResultTitle() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("=========================================");
    }

    private static void printThreeMatchResult(Lottos lottos, List<Integer> winningLotto) {
        int count = (int) lottos.findCountOfThreeNumMatching(winningLotto);
        MatchingResult.THREE.printHowManyMatch(count);
    }

    private static void printFourMatchResult(Lottos lottos, List<Integer> winningLotto) {
        int count = (int) lottos.findCountOfFourNumMatching(winningLotto);
        MatchingResult.FOUR.printHowManyMatch(count);
    }

    private static void printFiveMatchResult(Lottos lottos, List<Integer> winningLotto) {
        int count = (int) lottos.findCountOfFiveNumMatching(winningLotto);
        MatchingResult.FIVE.printHowManyMatch(count);
    }

    private static void printSixMatchResult(Lottos lottos, List<Integer> winningLotto) {
        int count = (int) lottos.findCountOfSixNumMatching(winningLotto);
        MatchingResult.SIX.printHowManyMatch(count);
    }

    private static void printMyEarningRate(Lottos lottos, List<Integer> winningLotto) {
        System.out.println("총 수익률은 " + lottos.calculateEarningRate(winningLotto) + " 입니다.");
    }
}