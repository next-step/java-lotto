package lotto.view;

import lotto.model.*;

import java.util.List;

public class ResultView {

    public void purchaseLottoCount(int manualCount, int autoCount) {

        System.out.println("수동으로 " + manualCount + "장, 자동으로 " + autoCount + "개를 구매했습니다.");
    }

    public void printToAutoLotto(Lotto2 lotto2) {

        System.out.println(lotto2.toString());
    }
    public void purchaseHistory(long purchaseCount, Lotto lotto) {

        System.out.println(purchaseCount + "개를 구매했습니다.");
        lotto.printToLottoNumber();
    }

    public void printToWinningStatistics(Lotto lotto) {

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        lotto.printToResultWinning();
        lotto.printToTotAteOfReturn();

    }

    public void printToWinningStatistics2(UserLotto userLotto,
                                          WinningLotto winningLotto,
                                          long purchaseAmount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + userLotto.matchCount(winningLotto, Level2.FIFTH) + "개");
        System.out.println("4개 일치 (50000원)- " + userLotto.matchCount(winningLotto, Level2.FOURTH) + "개");
        System.out.println("4개 일치 (50000원)- " + userLotto.matchCount(winningLotto, Level2.THIRD) + "개");
        System.out.println("3개 일치 (30000000)- " + userLotto.matchCount(winningLotto, Level2.SECOND) + "개");
        System.out.println("3개 일치 (2000000000)- " + userLotto.matchCount(winningLotto, Level2.FIRST) + "개");
        System.out.println("총 수익률은 " + userLotto.getTotAteOfReturn(winningLotto, purchaseAmount)
        + "입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
