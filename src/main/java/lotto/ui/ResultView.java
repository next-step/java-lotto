package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;

public class ResultView {
    private static final String COUNT_OF_PURCHASE_MESSAGE = "%s개를 구매했습니다.";
    private static final String LINE_SEPARATOR = "line.separator";
    private static final String RESULT_TEMPLATE_MESSAGE = "당첨 통계";
    private static final String LINE_DIVIDER = "--------";
    private static final String RESULT_STATS_MESSAGE = "%s개 일치 (%s원)- %s개";
    private static final String YIELD_OF_LOTTO_MESSAGE = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
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
            stringBuilder.append(String.format(RESULT_STATS_MESSAGE, i + 3, prize(i + 3), validStats[i]));
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

    private static int prize(int countOfMatch) {
        if (countOfMatch == 3) {
            return 5000;
        }
        if (countOfMatch == 4) {
            return 50000;
        }
        if (countOfMatch == 5) {
            return 1500000;
        }
        if (countOfMatch == 6) {
            return 2000000000;
        }
        return 0;
    }

    public static void printYield(int[] stats, int price) {
        int profit = 0;
        int[] validStats = filterValidStats(stats);
        for (int i = 0, len = validStats.length; i < len; i++) {
            profit = calculateProfit(profit, i + MIN_LOTTO_WINNER_BOUNDARY, validStats[i]);
        }
        System.out.println(String.format(YIELD_OF_LOTTO_MESSAGE, profit / price));
    }

    private static int calculateProfit(int profit, int countOfMatch, int countOfLotto) {
        return profit + prize(countOfMatch) * countOfLotto;
    }
}
