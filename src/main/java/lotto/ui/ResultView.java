package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;

public class ResultView {
    public static void printPurChaseCount(int manualPurchaseCount, int autoPurchaseCount) {
        printMessage(String.format("수동으로 %d장, 자동으로 %d장을 구매했습니다.", manualPurchaseCount, autoPurchaseCount));
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printMessage(lotto.getNumbers().toString());
        }
    }

    public static void printWinningStatus(List<Rank> results) {
        printMessage("당첨 통계");
        printMessage("---------");

        printMessage("3개 일치 (5000원) - " + results.stream().filter(r -> r == Rank.FIFTH).count());
        printMessage("4개 일치 (50000원) - " + results.stream().filter(r -> r == Rank.FOURTH).count());
        printMessage("5개 일치 (1500000원) - " + results.stream().filter(r -> r == Rank.THIRD).count());
        printMessage("5개 일치, 보너스 볼 일치(30000000원) - " + results.stream().filter(r -> r == Rank.SECOND).count());
        printMessage("6개 일치 (2000000000원) - " + results.stream().filter(r -> r == Rank.FIRST).count());
    }

    public static void printRateOfRevenue(double rateOfRevenue) {
        printMessage(String.format(
                "총 수익률은 %.2f 입니다. (기준이 1이기 때문에 1보다 작으면 결과적으로 손해라는 의미임)",
                rateOfRevenue
        ));
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
