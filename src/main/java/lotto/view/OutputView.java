package lotto.view;

import lotto.model.LottoTickets;
import lotto.model.LottoResult;
import lotto.model.LottoResults;

import java.math.BigDecimal;
import java.util.Map;

public class OutputView {
    private static final String RESULT_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String RESULT_WITH_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
    private static final String PURCHASE_SHOW_FORMAT = "%d개를 구매했습니다.";
    private static final String PROFIT_SHOW_FORMAT = "총 수익률은 %.2f입니다.";
    private static final String PROFIT_WITH_LOSS_SHOW_FORMAT = PROFIT_SHOW_FORMAT + "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private OutputView() {
    }

    public static void printLottoTickets(final LottoTickets lottoTickets) {
        System.out.println(String.format(PURCHASE_SHOW_FORMAT, lottoTickets.size()));
        System.out.println(lottoTickets.toString());
        System.out.println();
    }

    public static void printLottoResults(final LottoResults lottoResults) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        Map<LottoResult, Long> printResult = lottoResults.getResult();
        printResult.keySet()
                .stream()
                .filter(lottoResult -> !lottoResult.isBlank())
                .forEach(lottoResult -> printEachResult(lottoResult, lottoResults.count(lottoResult)));
        printProfitResult(lottoResults.profit());
    }

    private static void printEachResult(final LottoResult lottoResult, final Long resultCount) {
        if (lottoResult.equals(LottoResult.FIVE_WITH_BONUS)) {
            printWinResult(lottoResult, resultCount, RESULT_WITH_BONUS_FORMAT);
            return;
        }

        printWinResult(lottoResult, resultCount, RESULT_FORMAT);
    }

    private static void printWinResult(final LottoResult lottoResult, final Long resultCount, final String resultFormat) {
        System.out.println(String.format(
                resultFormat,
                lottoResult.getMatchCount(),
                lottoResult.getPrice(),
                resultCount));
    }

    private static void printProfitResult(final BigDecimal profit) {
        if (profit.compareTo(BigDecimal.valueOf(1)) < 0) {
            System.out.println(String.format(PROFIT_WITH_LOSS_SHOW_FORMAT, profit));
            return;
        }
        System.out.println(String.format(PROFIT_SHOW_FORMAT, profit));
    }
}
