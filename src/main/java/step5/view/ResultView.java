package step5.view;

import step5.lotto.LottoTicket;
import step5.winning.WinningPrize;
import step5.winning.WinningStatistics;

import java.math.BigDecimal;
import java.util.*;

public class ResultView {
    private static final String PURCHASE_PRINT = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String HYPHENS = "---------";
    private static final String TOTAL_YIELD = "총 수익률은";
    private static final String LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String PROFIT_MESSAGE = "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
    private static final int MEANING_DEFAULT_VALUE = 1;

    private ResultView() {
        throw new AssertionError();
    }

    public static void printLotto(List<LottoTicket> tickets) {
        for (int i = 0; i < tickets.size(); i++) {
            printLottoTicket(tickets.get(i));
        }
    }

    public static void printLottoTicket(LottoTicket ticket) {
        System.out.println(ticket.getLottoNumberList());
    }

    public static void printStatisticsIntroduction() {
        System.out.println();
        System.out.println(WINNING_STATISTICS);
        System.out.println(HYPHENS);
    }

    public static void printStatistics(final WinningStatistics lottoStatistics) {
        printStatisticsIntroduction();
        printWinningResults(lottoStatistics.getWinningResults());
        printWinningYield(lottoStatistics.getYield());
    }

    public static void printWinningResults(Map<WinningPrize, Integer> winningResults) {
        for (WinningPrize value: WinningPrize.values()) {
            printWinningResultEqual(value, winningResults.get(value));
        }
    }

    private static void printWinningResultEqual(WinningPrize value, Integer winningCount) {
        if (winningCount == null) {
            winningCount = 0;
        }
        if (!value.equals(WinningPrize.ZERO)) {
            System.out.println(String.format(value.getWinningMessage(), winningCount));
        }
    }
    public static void printWinningYield(BigDecimal yield) {
        System.out.print(TOTAL_YIELD + yield + getMessage(yield));
    }

    private static String getMessage(BigDecimal revenueRate) {
        if (revenueRate.intValue() < MEANING_DEFAULT_VALUE) {
            return LOSS_MESSAGE;
        }
        return PROFIT_MESSAGE;
    }

    public static void printPurchasePrice(int lottoCount) {
        System.out.println(lottoCount + PURCHASE_PRINT);
    }
}
