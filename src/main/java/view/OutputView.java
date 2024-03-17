package view;

import java.math.BigDecimal;
import java.util.List;

import model.Lotto;
import model.WinningDetails;
import model.WinningPrice;

public class OutputView {

    public void printLottoPurchaseCount(final int lottoPurchaseCount) {
        System.out.println(lottoPurchaseCount + "개를 구매했습니다.");
    }

    public void printPurchaseLottos(final List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printWinningStatistics(final WinningDetails winningDetails, final BigDecimal profit) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println(WinningPrice.FIRST.getMatchingCount() + "개 일치 (" + WinningPrice.FIRST.getAmount() + "원)-" + winningDetails.getWinningDetails().get(WinningPrice.FIRST) + "개");
        System.out.println(WinningPrice.SECOND.getMatchingCount() + "개 일치 (" + WinningPrice.SECOND.getAmount() + "원)-" + winningDetails.getWinningDetails().get(WinningPrice.SECOND) + "개");
        System.out.println(WinningPrice.THIRD.getMatchingCount() + "개 일치 (" + WinningPrice.THIRD.getAmount() + "원)-" + winningDetails.getWinningDetails().get(WinningPrice.THIRD) + "개");
        System.out.println(WinningPrice.FOURTH.getMatchingCount() + "개 일치 (" + WinningPrice.FOURTH.getAmount() + "원)-" + winningDetails.getWinningDetails().get(WinningPrice.FOURTH) + "개");
        System.out.println("총 수익률은 " + profit + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
