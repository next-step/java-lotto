package lotto.view;

import lotto.model.Budget;
import lotto.model.LottoResults;
import lotto.model.Lottos;

import static lotto.model.LottoResults.*;

public class OutputView {
    public static void printPurchaseCount(int count) {
        System.out.printf("%s개를 구매했습니다.%n", count);
    }

    public static void printResults(LottoResults result, Budget budget) {
        printResultHeader();
        printMatchCounts(result, budget);
        printRate(result, budget);
    }

    public static void printBoughtLottos(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    private static void printResultHeader() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private static void printMatchCounts(LottoResults results, Budget budget) {
        System.out.printf("3개 일치 (%s원)- %s개%n", PRIZE_THREE_MATCHES, results.threeMatches());
        System.out.printf("4개 일치 (%s원)- %s개%n", PRIZE_FOUR_MATCHES, results.fourMatches());
        System.out.printf("5개 일치 (%s원)- %s개%n", PRIZE_FIVE_MATCHES, results.fiveMatches());
        System.out.printf("6개 일치 (%s원)- %s개%n", PRIZE_SIX_MATCHES, results.sixMatches());
    }

    private static void printRate(LottoResults results, Budget budget) {
        double rate = results.getReturnRate(budget);
        System.out.printf("총 수익률은 %.2f입니다.", rate);
        if (rate >= 1) {
            System.out.printf("(기준이 1이기 때문에 결과적으로 이득이라는 의미임)%n");
            return;
        }
        System.out.printf("(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n");
    }
}
