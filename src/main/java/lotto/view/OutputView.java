package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.WinningRank;
import lotto.service.WinningRankStatistics;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public static final String LINE = "---------";
    public static final String YIELD_MESSAGE = "총 수익률은 %.2f입니다.";
    private static final String SAME_NUMBER_COUNT_MESSAGE = "%s개 일치";
    private static final String PRICE_MESSAGE = " (%d원)";
    private static final String LOTTO_COUNT_MESSAGE = " - %d개";
    private static final String LOTTO_NUMBER_SPLITTER = ",";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String LOTTO_PREFIX = "[";
    private static final String LOTTO_SUFFIX = "]";
    private static final String LOTTO_DELIMITER = LOTTO_SUFFIX + "\n" + LOTTO_PREFIX;
    private static final String LOTTO_NUM_MESSAGE = "%s개를 구매했습니다.";
    private static final String MATCH_BONUS_MESSAGE = ", 보너스 볼 일치";
    private static final String LOTTO_PURCHASE_COUNT_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매하였습니다.";
    private static final PrintStream out = System.out;

    private OutputView() {
    }

    public static void showWinningRanks(WinningRankStatistics winningRankStatistics) {
        out.println(WINNING_STATISTICS_MESSAGE);
        out.println(LINE);

        out.println(getWinningRanksCountString(winningRankStatistics));
    }

    private static String getWinningRanksCountString(WinningRankStatistics winningRankStatistics) {
        Map<WinningRank, Integer> counter = winningRankStatistics.getCounter();

        return counter.keySet().stream()
                .filter(winningRank -> !winningRank.isFail())
                .map(winningRank -> getWinningRankString(winningRank) + getWinningRankCountString(counter.get(winningRank)))
                .collect(Collectors.joining("\n"));
    }

    private static String getWinningRankCountString(int count) {
        return String.format(LOTTO_COUNT_MESSAGE, count);
    }

    private static String getWinningRankString(WinningRank winningRank) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(SAME_NUMBER_COUNT_MESSAGE, winningRank.getSameNumberNum()));
        if (winningRank.haveBonus()) {
            stringBuilder.append(MATCH_BONUS_MESSAGE);
        }
        stringBuilder.append(String.format(PRICE_MESSAGE, winningRank.getPrice()));
        return stringBuilder.toString();
    }

    public static void showLottoCount(int manualCount, int autoCount) {
        out.println(String.format(LOTTO_PURCHASE_COUNT_MESSAGE, manualCount, autoCount));
    }

    public static void showLottos(Lottos lottos) {
        out.println(getLottosString(lottos));
    }

    private static String getLottosString(Lottos lottos) {
        String lottosString = lottos.getLottoList().stream()
                .map(OutputView::getLottoString)
                .collect(Collectors.joining(LOTTO_DELIMITER));
        return LOTTO_PREFIX + lottosString + LOTTO_SUFFIX;
    }

    private static String getLottoString(Lotto lotto) {
        return lotto.getNumbers().getNumbers()
                .stream()
                .map(Number::getNumber)
                .map(Object::toString)
                .collect(Collectors.joining(LOTTO_NUMBER_SPLITTER));
    }

    public static void showYield(BigDecimal yield) {
        out.println(getYieldString(yield));
    }

    private static String getYieldString(BigDecimal yield) {
        return String.format(YIELD_MESSAGE, yield);
    }
}
