package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoWinner;
import lotto.domain.LottoWinnerType;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoWinnerType.NON_WIN;

public class ResultView {
    private static final String COUNT_OF_PURCHASE_MESSAGE = "%s개를 구매했습니다.";
    private static final String LINE_SEPARATOR = "line.separator";
    private static final String RESULT_TEMPLATE_MESSAGE = "당첨 통계";
    private static final String LINE_DIVIDER = "--------";
    private static final String RESULT_STATS_MESSAGE = "%s개 일치 (%s원)- %s개";
    private static final String YIELD_OF_LOTTO_MESSAGE = "총 수익률은 %s입니다.(기준은 1임)";
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat();
    private static final int DECIMAL_PLACES = 2;

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

    public static void printWinnerStats(LottoWinner winners) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RESULT_TEMPLATE_MESSAGE);
        stringBuilder.append(System.getProperty(LINE_SEPARATOR));
        stringBuilder.append(LINE_DIVIDER);
        stringBuilder.append(System.getProperty(LINE_SEPARATOR));

        for (Map.Entry<LottoWinnerType, Integer> winner : winners.getWinners().entrySet()) {
            printWinnerStat(stringBuilder, winner);
        }

        System.out.println(stringBuilder.toString());
    }

    private static void printWinnerStat(StringBuilder stringBuilder, Map.Entry<LottoWinnerType, Integer> winner) {
        if (NON_WIN != winner.getKey()) {
            stringBuilder.append(String.format(RESULT_STATS_MESSAGE, winner.getKey().getCountOfDuplicate(), LottoWinnerType.prize(winner.getKey().getCountOfDuplicate()), winner.getValue()));
            stringBuilder.append(System.getProperty(LINE_SEPARATOR));
        }
    }

    public static void printYield(float yield) {
        DECIMAL_FORMAT.setMaximumFractionDigits(DECIMAL_PLACES);
        System.out.println(String.format(YIELD_OF_LOTTO_MESSAGE, DECIMAL_FORMAT.format(yield)));
    }
}
