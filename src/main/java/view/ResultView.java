package view;

import domain.LottoPrize;

import java.util.Map;
import java.util.stream.IntStream;

public class ResultView {
    private final String RESULT_STATISTIC = "당첨 통계";
    private final String HORIZONTAL = "---------";
    private final String STATISTIC_MENTION = "%d개 일치 (%d원)- %d개";

    private final int PRIZE_BEGINNING = 3;
    private final int PRIZE_ENDING = 7;

    public void displayResultMention() {
        System.out.println(RESULT_STATISTIC);
        System.out.println(HORIZONTAL);
    }

    public void displayStatistic(Map<Integer, Integer> lottoStatistics) {
        IntStream.range(PRIZE_BEGINNING, PRIZE_ENDING)
                .forEach(key -> System.out.println(
                        String.format(STATISTIC_MENTION,
                                key,
                                LottoPrize.valueOf(key),
                                lottoStatistics.get(key)
                        )));
    }
}
