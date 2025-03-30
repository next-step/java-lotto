package lotto;

import java.util.Map;

public class YieldCalculator {
    public static double calculateYield(Map<Rank, Long> result) {
        long totalWinningCount = result.values().stream()
                .mapToLong(Long::longValue)
                .sum();

       long totalWinningAmount = (result.getOrDefault(Rank.FIFTH, 0L) * Rank.FIFTH.getWinningMoney()) +
               (result.getOrDefault(Rank.FOURTH, 0L) * Rank.FOURTH.getWinningMoney()) +
               (result.getOrDefault(Rank.THIRD, 0L) * Rank.THIRD.getWinningMoney()) +
               (result.getOrDefault(Rank.SECOND, 0L) * Rank.SECOND.getWinningMoney()) +
               (result.getOrDefault(Rank.FIRST, 0L) * Rank.FIRST.getWinningMoney());

        return (double) totalWinningAmount / (totalWinningCount * LottoTicket.PRICE) * 100;
    }
}
