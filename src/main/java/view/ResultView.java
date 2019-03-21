package view;

import domain.Lotto;
import domain.LottoGame;
import domain.LottoResult;
import util.WinType;

public class ResultView {
    static void printLottos(LottoGame lottoGame) {
        lottoGame.getLottos().stream()
                .forEach(ResultView::printLotto);
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    static void printResult(LottoResult result) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (5000원)- " + result.countWin(WinType.THREE) + "개");
        System.out.println("4개 일치 (50000원)- " + result.countWin(WinType.FOUR) + "개");
        System.out.println("5개 일치 (1500000원)- " + result.countWin(WinType.FIVE) + "개");
        System.out.println("6개 일치 (2000000000원)- " + result.countWin(WinType.SIX) + "개");

        System.out.println("총 수익률은 " + result.getYield() + "입니다.");
    }
}
