package lotto.view;

import lotto.model.LottoTickets;
import lotto.model.LottoResult;
import lotto.model.LottoResults;
import lotto.model.dto.LottoWinStatResult;
import lotto.model.dto.LottoWinStatResults;

import java.math.BigDecimal;

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
        LottoWinStatResults lottoWinStatResults = lottoResults.getWinStatResults();
        lottoWinStatResults.getWinResult()
                .forEach(OutputView::printEachWinResult);
        printProfitResult(lottoResults.profit());
    }

    private static void printEachWinResult(final LottoWinStatResult lottoWinStatResult) {
        if (LottoResult.FIVE_WITH_BONUS.equals(lottoWinStatResult)) {
            printWinResult(lottoWinStatResult, RESULT_WITH_BONUS_FORMAT);
            return;
        }

        printWinResult(lottoWinStatResult, RESULT_FORMAT);
    }

    private static void printWinResult(final LottoWinStatResult lottoWinStatResult, final String resultFormat) {
        System.out.println(String.format(
                resultFormat,
                lottoWinStatResult.getMatchCount(),
                lottoWinStatResult.getPrice(),
                lottoWinStatResult.getCount()));
    }

    private static void printProfitResult(final BigDecimal profit) {
        if (profit.compareTo(BigDecimal.valueOf(1)) < 0) {
            System.out.println(String.format(PROFIT_WITH_LOSS_SHOW_FORMAT, profit));
            return;
        }
        System.out.println(String.format(PROFIT_SHOW_FORMAT, profit));
    }
}
