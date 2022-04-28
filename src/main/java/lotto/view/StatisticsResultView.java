package lotto.view;

import java.util.Map;

public class StatisticsResultView {

    private static final String OUTPUT_STATISTICS = "당첨 통계";
    private static final String OUTPUT_LINE = "=========";

    private StatisticsResultView() {
        throw new AssertionError();
    }

    public static void printStatistics(Map<Integer, Integer> statistics) {
        System.out.println(OUTPUT_STATISTICS);
        System.out.println(OUTPUT_LINE);
    }
}
