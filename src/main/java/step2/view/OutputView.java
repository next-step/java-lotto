package step2.view;

import java.util.Map;
import step2.model.LottoResult;
import step2.model.LottoResults;
import step2.model.PurchasedLottoTickets;

public class OutputView {

    private static final String PURCHASED_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String RESULT_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String PROFIT_FORMAT = "총 수익률은 %.2f입니다.";
    private static final String PROFIT_WITH_LOSS_FORMAT = PROFIT_FORMAT + "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printLottoNumber(PurchasedLottoTickets purchasedLottoTickets) {
        System.out.println(String.format(PURCHASED_COUNT_FORMAT, purchasedLottoTickets.size()));
        System.out.println(purchasedLottoTickets.toString());
        System.out.println();
    }

    public static void printLottoStatistics(LottoResults lottoResults) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        Map<LottoResult, Long> printResult = lottoResults.getResult();

        printResult.keySet()
            .stream()
            .filter(lottoResult -> !lottoResult.isBlank())
            .forEach(lottoResult -> printWinResult(lottoResult, lottoResults.count(lottoResult)));
    }

    private static void printWinResult(final LottoResult lottoResult, final Long resultCount) {
        System.out
            .println(String.format(RESULT_FORMAT, lottoResult.getMatchCount(), lottoResult.getPrice(), resultCount));
    }

    public static void printProfitResult(final Double profit) {
        if (profit < 1) {
            System.out.println(String.format(PROFIT_WITH_LOSS_FORMAT, profit));
            return;
        }
        System.out.println(String.format(PROFIT_FORMAT, profit));
    }
}
