package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;

import java.util.List;

public class ResultView {
    private static final String COUNT_OF_PURCHASE_MESSAGE = "%s개를 구매했습니다.";
    private static final String LINE_SEPARATOR = "line.separator";
    private static final String RESULT_TEMPLATE_MESSAGE = "당첨 통계";
    private static final String LINE_DIVIDER = "--------";
    private static final String RESULT_STATS_MESSAGE = "%s개 일치 (%s원)- %s개";
    private static final String YIELD_OF_LOTTO_MESSAGE = "총 수익률은 %s입니다.(기준은 1임)";
    private static final int MIN_LOTTO_WINNER_BOUNDARY = 3;

    private ResultView() {
    }

    public static void printCountOfLottos(int count) {
        System.out.println(String.format(COUNT_OF_PURCHASE_MESSAGE, count));
    }

    public static void printResultOfPurchase(List<Lotto> lottos) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.getLottoNumbers());
            stringBuilder.append(System.getProperty(LINE_SEPARATOR));
        }
        System.out.println(stringBuilder.toString());
    }

    public static void printWinningStatistics(int[] stats) {
        int[] validStats = filterValidStats(stats);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RESULT_TEMPLATE_MESSAGE);
        stringBuilder.append(System.getProperty(LINE_SEPARATOR));
        stringBuilder.append(LINE_DIVIDER);
        stringBuilder.append(System.getProperty(LINE_SEPARATOR));

        for (int i = 0, len = validStats.length; i < len; i++) {
            stringBuilder.append(String.format(RESULT_STATS_MESSAGE, i + 3, LottoStatistics.LottoWinnerType.prize(i + 3), validStats[i]));
            stringBuilder.append(System.getProperty(LINE_SEPARATOR));
        }

        System.out.println(stringBuilder.toString());
    }

    private static int[] filterValidStats(int[] stats) {
        int[] validStats = new int[4];
        for (int i = 0, len = 4; i < len; i++) {
           validStats[i] = stats[i + MIN_LOTTO_WINNER_BOUNDARY];
        }
        return validStats;
    }

    public static void printYield(int yield) {
        System.out.println(String.format(YIELD_OF_LOTTO_MESSAGE, yield));
    }
}
