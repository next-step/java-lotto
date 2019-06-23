package lotto.view;

import lotto.domain.*;

import java.io.PrintStream;

public class ResultView {

    private static final PrintStream printStream = System.out;

    private static final String PURCHASED_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String STATISTICS_MESSAGE = "당첨 통계\n---------";
    private static final String GAIN = "이득";
    private static final String LOSS = "손해";

    private static final String STATISTIC_MESSAGE_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String STATISTIC_HAS_BONUS_BALL_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원)- %d개";
    private static final String EARN_RATE_FORMAT = "총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";

    public static void printPurchasedLottoCount(int lottoCount) {

        printStream.println(lottoCount + PURCHASED_LOTTO_COUNT_MESSAGE);
    }

    public static void printLottosNumber(Lottos lottos) {

        printStream.println(lottos.toString());
    }

    public static void printStatistics(Statistics statistics) {

        printStream.println(STATISTICS_MESSAGE);
        statistics.getStatistics().forEach(ResultView::printStatistic);
        printEarnRate(statistics);
    }

    private static void printStatistic(Statistic statistic) {

        if (statistic.getPrizeRule().hasBonusNumber()) {
            printStream.println(String.format(STATISTIC_HAS_BONUS_BALL_MESSAGE_FORMAT, statistic.getPrizeRule().getNormalNumberCount(), statistic.getPrizeMoney(), statistic.getPrizeCount()));
            return;
        }
        printStream.println(String.format(STATISTIC_MESSAGE_FORMAT, statistic.getPrizeRule().getNormalNumberCount(), statistic.getPrizeMoney(), statistic.getPrizeCount()));
    }

    private static void printEarnRate(Statistics statistic) {

        printStream.println(String.format(EARN_RATE_FORMAT, statistic.getEarnRate(), statistic.isGain() ? GAIN : LOSS));

    }
}
