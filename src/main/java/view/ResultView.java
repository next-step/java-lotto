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
        System.out.println(lotto);
    }

    static void printResult(LottoResult result) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (5000원)- " + result.countWin(WinType.FIFTH) + "개");
        System.out.println("4개 일치 (50000원)- " + result.countWin(WinType.FOURTH) + "개");
        System.out.println("5개 일치 (1500000원) " + result.countWin(WinType.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + result.countWin(WinType.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원)- " + result.countWin(WinType.FIRST) + "개");

        System.out.println("총 수익률은 " + result.getYield() + "입니다.");
    }
}
