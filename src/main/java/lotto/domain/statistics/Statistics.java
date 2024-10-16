package lotto.domain.statistics;

import lotto.domain.Prize;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Statistics {
    private static final List<Prize> PRIZE_MATCH_COUNT = List.of(Prize.MISS, Prize.FIFTH, Prize.FOURTH, Prize.THIRD, Prize.SECOND, Prize.FIRST);
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final int PRICE_TYPES_COUNT = 6;

    public static List<Integer> getPrizeCounts(Map<Prize, Integer> prizeCountMap) {
        List<Integer> prizeCounts = new ArrayList<>();
        for (int i = 0; i < PRICE_TYPES_COUNT; i++) {
            int priceCount = prizeCountMap.getOrDefault(PRIZE_MATCH_COUNT.get(i), 0);
            prizeCounts.add(priceCount);
        }
        return prizeCounts;
    }

    public static double calculateReturnRatio(int lottoPurchaseCount, Map<Prize, Integer> prizeCountMap) {
        return Math.floor(calculateRatio(lottoPurchaseCount, calculateTotalPrizeAmount(getTotalPrizeAmounts(prizeCountMap))) * 100.0) / 100.0;
    }

    public static List<Integer> getTotalPrizeAmounts(Map<Prize, Integer> prizeCountMap) {
        List<Integer> totalPrizeAmounts = new ArrayList<>();
        for (int i = 0; i < PRICE_TYPES_COUNT; i++) {
            int prizeCount = prizeCountMap.getOrDefault(PRIZE_MATCH_COUNT.get(i), 0);
            totalPrizeAmounts.add(prizeCount * PRIZE_MATCH_COUNT.get(i).getPrice());
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
