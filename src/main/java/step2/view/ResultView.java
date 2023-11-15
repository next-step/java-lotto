package step2.view;

import org.apache.commons.lang3.StringUtils;
import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.domain.WinningStatistics;
import step2.domain.type.Prize;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ResultView {

    private static final String PURCHASE_MESSAGE = "%s개를 구매했습니다.";
    private static final String LOTTO_NUMBER_MESSAGE = "[%s]";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String DIVIDING_LINE = "---------";
    private static final String MATCH_MESSAGE = "%d개 일치%s (%.0f원)- %d개";
    private static final String BONUS_MATCH_ADDITIONAL_MESSAGE = ", 보너스 볼 일치";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.2f입니다.";
    private static final String COMMA = ", ";

    public void printPurchaseMessage(int count) {
        System.out.println(String.format(PURCHASE_MESSAGE, count));
    }

    public void printLottos(Lottos lottos) {
        lottos.lottos().stream().forEach(lotto -> printLotto(lotto));
        System.out.println();
    }

    private void printLotto(Lotto lotto) {
        System.out.println(String.format(LOTTO_NUMBER_MESSAGE, lottoText(lotto)));
    }

    private String lottoText(Lotto lotto) {
        return StringUtils.join(sortedLottoNumbers(lotto.numbers()), COMMA);
    }

    private List<Integer> sortedLottoNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public void printWinningStatistics(WinningStatistics winningStatistics) {
        System.out.println();
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DIVIDING_LINE);

        printWinningStatisticsPerPrize(winningStatistics);
    }

    private void printWinningStatisticsPerPrize(WinningStatistics winningStatistics) {
        Arrays.stream(Prize.values())
            .filter(Prize::isWinningPrize)
            .map(prize -> winningStatisticsText(prize, winningStatistics))
            .forEach(System.out::println);
    }

    private String winningStatisticsText(Prize prize, WinningStatistics winningStatistics) {
        if (prize.useBonusAndMatched()) {
            return winningStatisticsText(BONUS_MATCH_ADDITIONAL_MESSAGE, prize, winningStatistics);
        }
        return winningStatisticsText(StringUtils.EMPTY, prize, winningStatistics);
    }

    private String winningStatisticsText(String additionalMessage, Prize prize, WinningStatistics winningStatistics) {
        return String.format(MATCH_MESSAGE,
            prize.matchCount(),
            additionalMessage,
            prize.prizeMoney(),
            winningStatistics.winningLottoCountByPrize(prize));
    }

    public void printRateOfReturn(BigDecimal price, WinningStatistics winningStatistics) {
        System.out.println(rateOfReturnText(price, winningStatistics));
    }

    private String rateOfReturnText(BigDecimal price, WinningStatistics winningStatistics) {
        return String.format(RATE_OF_RETURN_MESSAGE, winningStatistics.rateOfReturn(price));
    }

}
