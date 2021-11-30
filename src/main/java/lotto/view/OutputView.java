package lotto.view;

import lotto.LottoPaper;
import lotto.LottoResult;
import lotto.model.WinningPrice;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.model.WinningPrice.*;

public class OutputView {
    private final static String OUTPUT_STATISTICS_MESSAGE = "당첨 통계\n---------";
    private final static String OUTPUT_WINNING_MESSAGE_FORMAT = "%s개 일치 (%s원) - %s개";
    private final static String OUTPUT_WINNING_MESSAGE_BONUS_MATCHED_FORMAT = "%s개 일치, 보너스 볼 일치" +
            "(%s원) - %s개";
  
    private final static String OUTPUT_YIELD_MESSAGE_FORMAT = "총 수익률은 %.2f%% 입니다.";

    public void printLottoPaper(LottoPaper lottoPaper) {
        String str = getLottoNumberValuesString(lottoPaper.getNumberValues());
        System.out.println(str);
    }

    public void printStatistics(LottoResult lottoResult) {
        System.out.println(OUTPUT_STATISTICS_MESSAGE);

        printWinningResult(FIFTH, false, lottoResult);
        printWinningResult(FORTH, false, lottoResult);
        printWinningResult(THIRD, false, lottoResult);
        printWinningResult(SECOND, true, lottoResult);
        printWinningResult(FIRST, false, lottoResult);

        System.out.printf((OUTPUT_YIELD_MESSAGE_FORMAT) + "%n", lottoResult.getYield());
    }

    private String getLottoNumberValuesString(List<Integer> values) {
        return "[ " + values.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "))
                + " ]";
    }

    private void printWinningResult(WinningPrice winningPrice, boolean isBonusMatch,
                                    LottoResult lottoResult) {
        WinningPrice price = WinningPrice.of(winningPrice.getWinningCount(), isBonusMatch);

        String formatMessage = isBonusMatch ? OUTPUT_WINNING_MESSAGE_BONUS_MATCHED_FORMAT :
                OUTPUT_WINNING_MESSAGE_FORMAT;
        System.out.printf(formatMessage + "%n", winningPrice.getWinningCount(), price.getPrice(),
                lottoResult.getWinningCount(price));
    }
}
