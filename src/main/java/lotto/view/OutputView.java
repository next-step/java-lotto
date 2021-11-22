package lotto.view;

import lotto.LottoPaper;
import lotto.LottoResult;
import lotto.model.WinningPrice;

public class OutputView {
    private final static String OUTPUT_STATISTICS_MESSAGE = "당첨 통계\n---------";
    private final static String OUTPUT_WINNING_MESSAGE_FORMAT = "%s개 일치 (%s원) - %s개";
    private final static String OUTPUT_YIELD_MESSAGE_FORMAT = "총 수익률은 %.2f%% 입니다.";

    public void printLottoPaper(LottoPaper lottoPaper) {
        System.out.println(lottoPaper.toString());
    }

    public void printStatistics(LottoResult lottoResult) {
        System.out.println(OUTPUT_STATISTICS_MESSAGE);

        printWinningResult(3, lottoResult);
        printWinningResult(4, lottoResult);
        printWinningResult(5, lottoResult);
        printWinningResult(6, lottoResult);

        System.out.printf((OUTPUT_YIELD_MESSAGE_FORMAT) + "%n", lottoResult.getYield());
    }

    private void printWinningResult(int winningCount, LottoResult lottoResult) {
        WinningPrice price = WinningPrice.of(winningCount);
        System.out.printf((OUTPUT_WINNING_MESSAGE_FORMAT) + "%n", winningCount, price.getPrice(),
                lottoResult.getWinningCount(price));
    }
}
