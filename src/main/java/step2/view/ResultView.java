package step2.view;

import step2.domain.LottoResult;
import step2.domain.LottosTotalResult;

public class ResultView {
    public static void printStartOfResult() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void printTotalResult(LottosTotalResult lottosResult, int purchasePrice) {
        printStartOfResult();
        for (LottoResult result : LottoResult.values()) {
            printEachResult(result, lottosResult.get(result.numbersToBeMatched));
        }
        printRateOfReturn(lottosResult.getRateOfReturn(purchasePrice));
    }

    public static void printEachResult(LottoResult result, int numberOfMatched) {
        System.out.printf("%d개 일치 (%d원)- %d개%n", result.numbersToBeMatched, result.winningPrice, numberOfMatched);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.2f입니다.", rateOfReturn);
    }
}
