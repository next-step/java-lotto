package lotto.view;

import java.util.Map;

public class StatisticsResultView {

    private static final String OUTPUT_STATISTICS = "당첨 통계";
    private static final String OUTPUT_LINE = "=========";
    private static final String OUTPUT_WINNINGS = "%d개 일치 (%d원)- %d개";
    private static final String OUTPUT_YIELD = "총 수익률은 %.2f 입니다.";
    private static final long[] WINNINGS = new long[]{0, 0, 0, 5_000, 50_000, 1_500_000, 2_000_000_000};
    private static final int DEFAULT_VALUE = 0;
    private static final int WINNINGS_START = 3;
    private static final int WINNINGS_END = 6;

    private StatisticsResultView() {
        throw new AssertionError();
    }

    public static void printStatistics(int buyingMoney, Map<Integer, Integer> statistics) {
        System.out.println(OUTPUT_STATISTICS);
        System.out.println(OUTPUT_LINE);

        long result = printWinningsAndGetSum(statistics);
        printYield(buyingMoney, result);
    }

    private static long printWinningsAndGetSum(Map<Integer, Integer> statistics) {
        long result = 0;
        for (int i = WINNINGS_START; i <= WINNINGS_END; i++) {
            int count = statistics.getOrDefault(i, DEFAULT_VALUE);
            System.out.println(String.format(OUTPUT_WINNINGS, i, WINNINGS[i], count));
            result += count * WINNINGS[i];
        }
        return result;
    }

    private static void printYield(int buyingMoney, long result) {
        System.out.println(String.format(OUTPUT_YIELD, getYield(buyingMoney, result)));
    }

    private static double getYield(int buyingMoney, long result) {
        return result / (double) buyingMoney;
    }
}
