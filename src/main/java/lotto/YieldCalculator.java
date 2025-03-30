package lotto;

import java.util.Map;

public class YieldCalculator {
    public static double calculateYield(Map<Long, Long> result) {
        long totalWinningCount = result.values().stream()
                .mapToLong(Long::longValue)
                .sum();

        long totalWinningAmount = (result.getOrDefault(3L, 0L) * 5000) +
                (result.getOrDefault(4L, 0L) * 50000) +
                (result.getOrDefault(5L, 0L) * 500000) +
                (result.getOrDefault(6L, 0L) * 2000000000);

        return (double) totalWinningAmount / (totalWinningCount * LottoTicket.PRICE) * 100;
    }
}
