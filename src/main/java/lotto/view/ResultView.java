package lotto.view;

import lotto.controller.LottoGame;
import lotto.model.MyLottos;

import java.util.List;

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
//        printMyEarningRate(lottoGame.getLottoNumbers(), winningLotto);
    }
//
//    private static void printMatchResult(MyLottos myLottos, List<Integer> winningLotto) {
//        printBlankLine();
//        printMatchResults(myLottos, winningLotto);
//    }

    private static void printResultTitle() {
        printBlankLine();
        System.out.println("당첨 통계");
        System.out.println("=========================================");
    }

    public static void printMatchResults(MyLottos myLottos, List<Integer> winningLotto) {
        findHowManyMatch(myLottos.findHowManyMatchWith(winningLotto));
        printResult();
    }

    private static void findHowManyMatch(List<Integer> matchCounts) {
        for (Integer integer : matchCounts) {
            addCount(integer);
        }
    }

    private static void printResult() {
        System.out.println("3개 일치 " + threeMatchLottos + "개");
        System.out.println("4개 일치 " + fourMatchLottos + "개");
        System.out.println("5개 일치 " + fiveMatchLottos + "개");
        System.out.println("3개 일치 " + sixMatchLottos + "개");
    }

    private static void addCount(int matchCount){
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

    private static void printBlankLine(){
        System.out.println();
    }
}