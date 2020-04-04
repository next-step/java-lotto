package lotto.view;

import lotto.model.LottoWinningResult;
import lotto.model.LottoWinningResults;
import lotto.model.LottoTickets;
import lotto.model.dto.LottoWinningResultWithCount;
import lotto.model.dto.LottoTotalResult;

import java.math.BigDecimal;

public class OutputView {
    private static final String RESULT_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String RESULT_WITH_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
    private static final String PURCHASE_SHOW_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String PROFIT_SHOW_FORMAT = "총 수익률은 %.2f입니다.";
    private static final String PROFIT_WITH_LOSS_SHOW_FORMAT = PROFIT_SHOW_FORMAT + "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private OutputView() {
    }

    public static void printLottoTickets(final LottoTickets lottoTickets, final int manualLottoTicketCount) {
        System.out.println(String.format(PURCHASE_SHOW_FORMAT, manualLottoTicketCount, lottoTickets.size() - manualLottoTicketCount));
        System.out.println(lottoTickets.toString());
        System.out.println();
    }

    public static void printLottoResults(final LottoWinningResults lottoWinningResults) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        LottoTotalResult lottoTotalResult = LottoTotalResult.newInstance(lottoWinningResults);
        lottoTotalResult.getWinResult()
                .forEach(OutputView::printEachWinResult);
        printProfitResult(lottoTotalResult.getProfit());
    }

    private static void printEachWinResult(final LottoWinningResultWithCount lottoWinningResultWithCount) {
        if (LottoWinningResult.FIVE_WITH_BONUS == lottoWinningResultWithCount.getLottoWinningResult()) {
            printWinResult(lottoWinningResultWithCount, RESULT_WITH_BONUS_FORMAT);
            return;
        }

        printWinResult(lottoWinningResultWithCount, RESULT_FORMAT);
    }

    private static void printWinResult(final LottoWinningResultWithCount lottoWinningResultWithCount, final String resultFormat) {
        System.out.println(String.format(
                resultFormat,
                lottoWinningResultWithCount.getMatchCount(),
                lottoWinningResultWithCount.getPrice(),
                lottoWinningResultWithCount.getCount()));
    }

    private static void printProfitResult(final BigDecimal profit) {
        if (profit.compareTo(BigDecimal.valueOf(1)) < 0) {
            System.out.println(String.format(PROFIT_WITH_LOSS_SHOW_FORMAT, profit));
            return;
        }
        System.out.println(String.format(PROFIT_SHOW_FORMAT, profit));
    }
}
