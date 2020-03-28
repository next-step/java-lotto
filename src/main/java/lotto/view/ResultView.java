package lotto.view;

import lotto.domain.LottoGameResults;
import lotto.domain.LottoWinningLevel;

public class ResultView {
    private static final String RESULT_SUMMARY_MESSAGE = "당첨 통계";
    private static final String CARRIAGE_RETURN = "\n";
    private static final String DIVISION_LINE = "---------";
    private static final String MATCH_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static final String NET_PROFIT_MESSAGE =
            "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private static final int LOTTO_WIN_MIN = 3;
    private static final int LOTTO_WIN_MAX = 6;

    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void print(LottoGameResults results) {
        initMessage();
        for (int i = LOTTO_WIN_MIN; i <= LOTTO_WIN_MAX; i++) {
            printWinningResult(i, results.getMatchCount(i));
        }
        String profitMessage = String.format(NET_PROFIT_MESSAGE, results.getProfitRate());
        stringBuilder.append(profitMessage);

        System.out.println(stringBuilder.toString());
    }

    private static void initMessage() {
        stringBuilder.append(RESULT_SUMMARY_MESSAGE)
                .append(CARRIAGE_RETURN)
                .append(DIVISION_LINE)
                .append(CARRIAGE_RETURN);
    }

    private static void printWinningResult(int index, long matchCount) {
        String message = getString(index, matchCount);
        stringBuilder.append(message + CARRIAGE_RETURN);
    }

    private static String getString(int i, long count) {
        return String.format(
                MATCH_MESSAGE, i, LottoWinningLevel.of(i).getWinningPrize(), count
        );
    }

}
