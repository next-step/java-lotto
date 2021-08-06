package lotto.view;

import lotto.model.LottoShop;
import lotto.model.LottoStatistics;
import lotto.model.Lottos;
import lotto.prize.LottoPrize;

import java.util.Map;

public class ResultView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String DISPLAY_PURCHASES_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계" + NEW_LINE + "---------";
    private static final String PRIZE_RESULT_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String BONUS_PRIZE_RESULT_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원)- %d개";
    private static final String EARNINGS_RATE_FORMAT = "총 수익률은 %.2f입니다.";

    private ResultView() {
    }

    public static void printGameCount(final int money) {
        println(String.format(DISPLAY_PURCHASES_COUNT_FORMAT, (money / LottoShop.LOTTO_PRICE)));
    }

    public static void printLottoNumber(final Lottos lottos) {
        println(lottos.toString());
    }

    public static void printStatistic(final LottoStatistics statistics) {
        println(WINNING_STATISTICS_MESSAGE);
        StringBuilder stringBuilder = new StringBuilder();
        Map<LottoPrize, Integer> statisticsMap = statistics.getStatisticsMap();
        for (LottoPrize lottoPrize : statisticsMap.keySet()) {
            stringBuilder.append(getFormatString(statisticsMap, lottoPrize));
            stringBuilder.append(NEW_LINE);
        }
        stringBuilder.append(String.format(EARNINGS_RATE_FORMAT, statistics.getEarningsRate()));
        println(stringBuilder.toString());
    }

    private static String getFormatString(Map<LottoPrize, Integer> statisticsMap, LottoPrize lottoPrize) {
        return String.format(findMessageFormat(lottoPrize),
                             lottoPrize.getMatchCount(),
                             lottoPrize.getPrizeMoney(),
                             statisticsMap.get(lottoPrize));
    }

    private static String findMessageFormat(LottoPrize lottoPrize) {
        return lottoPrize == LottoPrize.SECOND ? BONUS_PRIZE_RESULT_FORMAT : PRIZE_RESULT_FORMAT;
    }

    private static void println(String string) {
        System.out.println(string);
    }
}
