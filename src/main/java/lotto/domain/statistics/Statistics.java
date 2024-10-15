package lotto.domain.statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Statistics {
    private static final List<Integer> PRIZE_MATCH_COUNT = List.of(3, 4, 5, 6);
    private static final List<Integer> PRIZE_AMOUNTS = List.of(5000, 50000, 1500000, 2000000000);
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final int PRICE_TYPES_COUNT = 4;

    public static List<Integer> getPrizeCounts(Map<Integer, Integer> prizeCountMap) {
        List<Integer> prizeCounts = new ArrayList<>();
        for (int i = 0; i < PRICE_TYPES_COUNT; i++) {
            int priceCount = prizeCountMap.getOrDefault(PRIZE_MATCH_COUNT.get(i), 0);
            prizeCounts.add(priceCount);
        }
        return prizeCounts;
    }

    public static double calculateReturnRatio(int lottoPurchaseCount, Map<Integer, Integer> prizeCountMap) {
        return Math.floor(calculateRatio(lottoPurchaseCount, calculateTotalPrizeAmount(getTotalPrizeAmounts(prizeCountMap))) * 100.0) / 100.0;
    }

    public static List<Integer> getTotalPrizeAmounts(Map<Integer, Integer> prizeCountMap) {
        List<Integer> totalPrizeAmounts = new ArrayList<>();
        for (int i = 0; i < PRICE_TYPES_COUNT; i++) {
            int prizeCount = prizeCountMap.getOrDefault(PRIZE_MATCH_COUNT.get(i), 0);
            totalPrizeAmounts.add(prizeCount * PRIZE_AMOUNTS.get(i));
        }
        return totalPrizeAmounts;
    }

    private static int calculateTotalPrizeAmount(List<Integer> prizeAmounts) {
        int totalPrizeAmount = 0;
        for (int prizeAmount : prizeAmounts) {
            totalPrizeAmount += prizeAmount;
        }
        return totalPrizeAmount;
    }

    private static double calculateRatio(int lottoPurchaseCount, int totalPrizeAmount) {
        int totalPurchaseMount = lottoPurchaseCount * LOTTO_TICKET_PRICE;
        return (double) totalPrizeAmount / totalPurchaseMount;
    }
}
