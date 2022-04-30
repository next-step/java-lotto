package lotto.view;

import lotto.model.Lotto;
import lotto.model.Money;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    private static final String OUTPUT_BUYING_LOTTOS = "%d개를 구매했습니다.";
    private static final String DELIMITER = ", ";
    private static final String OUTPUT_OPEN_BRACKET = "[";
    private static final String OUTPUT_CLOSE_BRACKET = "]";
    private static final String OUTPUT_STATISTICS = "당첨 통계";
    private static final String OUTPUT_LINE = "=========";
    private static final String OUTPUT_WINNINGS = "%d개 일치 (%d원)- %d개";
    private static final String OUTPUT_YIELD = "총 수익률은 %.2f 입니다.";
    private static final long[] WINNINGS = new long[]{0, 0, 0, 5_000, 50_000, 1_500_000, 2_000_000_000};
    private static final int DEFAULT_VALUE = 0;
    private static final int WINNINGS_START = 3;
    private static final int WINNINGS_END = 6;

    private ResultView() {
        throw new AssertionError();
    }

    public static void printBuyingLottos(List<Lotto> buyingLottos) {
        System.out.println(String.format(OUTPUT_BUYING_LOTTOS, buyingLottos.size()));

        for (Lotto lotto : buyingLottos) {
            printLottos(lotto);
        }
    }

    private static void printLottos(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        sb.append(OUTPUT_OPEN_BRACKET);
        sb.append(lotto.get()
                .stream()
                .map(num -> String.valueOf(num))
                .collect(Collectors.joining(DELIMITER)));
        sb.append(OUTPUT_CLOSE_BRACKET);
        System.out.println(sb);
    }

    public static void printStatistics(Money buyingMoney, Map<Integer, Integer> statistics) {
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

    private static void printYield(Money buyingMoney, long result) {
        System.out.println(String.format(OUTPUT_YIELD, buyingMoney.getYield(result)));
    }
}
