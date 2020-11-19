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
    private static final String WINNING_RANK_COUNT = "%s개 일치 (%d원)- %d개";
    private static final String LOTTO_NUMBER_SPLITTER = ",";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String LOTTO_PREFIX = "[";
    private static final String LOTTO_SUFFIX = "]";
    private static final String LOTTO_DELIMITER = LOTTO_SUFFIX + "\n" + LOTTO_PREFIX;
    private static final String LOTTO_NUM_MESSAGE = "%s개를 구매했습니다.";
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
                .map(winningRank -> getWinningRankCountString(winningRank, counter.get(winningRank)))
                .collect(Collectors.joining("\n"));
    }

    private static String getWinningRankCountString(WinningRank winningRank, int count) {
        return String.format(WINNING_RANK_COUNT, getWinningRankSameNumberString(winningRank), winningRank.getPrice(), count);
    }

    private static String getWinningRankSameNumberString(WinningRank winningRank) {
        return winningRank.getSameNumberNums().stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public static void showLottoNum(int lottoNum) {
        out.println(getLottoNumString(lottoNum));
    }

    private static String getLottoNumString(int lottoNum) {
        return String.format(LOTTO_NUM_MESSAGE, lottoNum);
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
