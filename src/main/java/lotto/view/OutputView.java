package lotto.view;

import lotto.model.PurchaseAmount;
import lotto.model.LottoResults;
import lotto.model.Lottos;

import static lotto.model.LottoResults.*;

public class OutputView {
    public static void printPurchaseCount(int count) {
        System.out.printf("%s개를 구매했습니다.%n", count);
    }

    public static void printResults(LottoResults result, PurchaseAmount purchaseAmount) {
        printResultHeader();
        printMatchCounts(result);
        printRate(result, purchaseAmount);
    }

    public static void printBoughtLottos(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    private static void printResultHeader() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private static void printMatchCounts(LottoResults results) {
        System.out.printf("%s- %s개%n", Prize.THREE_MATCHES, results.getMatchCount(3));
        System.out.printf("%s- %s개%n", Prize.FOUR_MATCHES, results.getMatchCount(4));
        System.out.printf("%s- %s개%n", Prize.FIVE_MATCHES, results.getMatchCount(5));
        System.out.printf("%s- %s개%n", Prize.SIX_MATCHES, results.getMatchCount(6));
    }

    private static void printRate(LottoResults results, PurchaseAmount purchaseAmount) {
        double rate = results.getReturnRate(purchaseAmount);
        System.out.printf("총 수익률은 %.2f입니다.", rate);
        if (rate >= 1) {
            System.out.printf("(기준이 1이기 때문에 결과적으로 이득이라는 의미임)%n");
            return;
        }
        System.out.printf("(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n");
    }
}
