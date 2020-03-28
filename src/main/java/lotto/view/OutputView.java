package lotto.view;

import lotto.model.LottoPurchaseTickets;
import lotto.model.LottoResult;
import lotto.model.LottoResults;

import java.util.Map;

public class OutputView {
    private static final String RESULT_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String PURCHASE_SHOW_FORMAT = "%d개를 구매했습니다.";
    private static final String PROFIT_SHOW_FORMAT = "총 수익률은 %.2f입니다.";
    private static final String PROFIT_WITH_LOSS_SHOW_FORMAT = PROFIT_SHOW_FORMAT + "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private OutputView() {
    }

    public static void printLottoTickets(final LottoPurchaseTickets lottoPurchaseTickets) {
        System.out.println(String.format(PURCHASE_SHOW_FORMAT, lottoPurchaseTickets.size()));
        System.out.println(lottoPurchaseTickets.toString());
        System.out.println();
    }

    public static void printLottoResults(final LottoResults lottoResults) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        Map<LottoResult, Long> printResult = lottoResults.getResult();
        printResult.keySet()
                .stream()
                .filter(lottoResult -> !lottoResult.isBlank())
                .forEach(lottoResult -> printWinResult(lottoResult, lottoResults.count(lottoResult)));
        printProfitResult(lottoResults.profit());
    }

    private static void printWinResult(final LottoResult lottoResult, final Long resultCount) {
        System.out.println(String.format(
                RESULT_FORMAT,
                lottoResult.getMatchCount(),
                lottoResult.getPrice(),
                resultCount));
    }

    private static void printProfitResult(final Double profit) {
        if (profit < 1) {
            System.out.println(String.format(PROFIT_WITH_LOSS_SHOW_FORMAT, profit));
            return;
        }
        System.out.println(String.format(PROFIT_SHOW_FORMAT, profit));
    }
}
