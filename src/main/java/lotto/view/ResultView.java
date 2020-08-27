package lotto.view;

import lotto.domain.*;

import static lotto.domain.Ranking.findStatistics;

public class ResultView {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String PURCHASE_COUNT_MESSAGE = "수동으로 %d장, 자동으로 %d장을 구매했습니다.";
    private static final String HEAD_STATISTICS_MESSAGE = String.format("%s당첨 통계%s---------", LINE_SEPARATOR, LINE_SEPARATOR);
    private static final String MATCHES_COUNT_MESSAGE = String.format(" - %%s개%s", LINE_SEPARATOR);
    private static final String TOTAL_PROFIT_MESSAGE = "총 수익률은 %.2f 입니다.";
    private static final String LOSS_NOTICE_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private ResultView() {}

    public static void displayLottoCount(int manualSize, int totalSize) {
        System.out.printf((PURCHASE_COUNT_MESSAGE) + "%n", manualSize, totalSize - manualSize);
    }

    public static void displayLottos(Lottos lottos) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.toString()).append(LINE_SEPARATOR);
        }
        System.out.println(stringBuilder.toString());
    }

    public static void displayLottoResult(Rankings rankings) {
        System.out.println(HEAD_STATISTICS_MESSAGE);

        StringBuilder stringBuilder = new StringBuilder();
        for (Ranking ranking : findStatistics()) {
            stringBuilder.append(ranking.getMessage());
            stringBuilder.append(String.format(MATCHES_COUNT_MESSAGE, rankings.rankingCount(ranking)));
        }

        double profitRate = rankings.findProfitRate();
        stringBuilder.append(String.format(TOTAL_PROFIT_MESSAGE, profitRate));

        if (profitRate < 1) {
            stringBuilder.append(LOSS_NOTICE_MESSAGE);
        }

        System.out.println(stringBuilder.toString());
    }
}
