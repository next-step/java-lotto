package step2.view;

import org.apache.commons.lang3.StringUtils;
import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.domain.WinningStatistics;
import step2.domain.type.Prize;

import java.math.BigDecimal;
import java.util.Arrays;

public class ResultView {

    private static final String PURCHASE_MESSAGE = "%s개를 구매했습니다.";
    private static final String LOTTO_NUMBER_MESSAGE = "[%s]";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String DIVIDING_LINE = "---------";
    private static final String MATCH_MESSAGE = "%d개 일치 (%.0f원)- %d개";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.2f입니다.";
    private static final String COMMA = ", ";

    public static void printPurchaseMessage(int count) {
        System.out.println(String.format(PURCHASE_MESSAGE, count));
    }

    public static void printLottos(Lottos lottos) {
        lottos.lottos().stream().forEach(ResultView::printLotto);
        System.out.println();
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(String.format(LOTTO_NUMBER_MESSAGE, lottoText(lotto)));
    }

    private static String lottoText(Lotto lotto) {
        return StringUtils.join(lotto.numbers(), COMMA);
    }

    public static void printWinningStatistics(WinningStatistics winningStatistics) {
        System.out.println();
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DIVIDING_LINE);

        printWinningStatisticsPerPrize(winningStatistics);
    }

    private static void printWinningStatisticsPerPrize(WinningStatistics winningStatistics) {
        Arrays.stream(Prize.values())
            .filter(Prize::isWinningPrize)
            .map(prize -> winningStatisticsText(prize, winningStatistics))
            .forEach(System.out::println);
    }

    private static String winningStatisticsText(Prize prize, WinningStatistics winningStatistics) {
        return String.format(MATCH_MESSAGE,
            prize.matchCount(),
            prize.prizeMoney(),
            winningStatistics.winningLottoCountByPrize(prize));
    }

    public static void printRateOfReturn(BigDecimal price, WinningStatistics winningStatistics) {
        System.out.println(rateOfReturnText(price, winningStatistics));
    }

    private static String rateOfReturnText(BigDecimal price, WinningStatistics winningStatistics) {
        return String.format(RATE_OF_RETURN_MESSAGE, winningStatistics.rateOfReturn(price));
    }

}
