package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningCalculator {
    private final Map<Winning, Integer> winningCountMap;

    public WinningCalculator(List<Integer> matchCounts) {
        winningCountMap = new LinkedHashMap<>();
        for (Winning winning : Winning.values()) {
            winningCountMap.put(winning, 0);
        }

        for (int matchCount : matchCounts) {
            Winning winning = Winning.fromMatchCount(matchCount);
            winningCountMap.put(winning, winningCountMap.get(winning) + 1);
        }
    }

    public Map<Winning, Integer> getWinningCountMap() {
        return winningCountMap.entrySet()
                              .stream()
                              .filter(winningCount -> winningCount.getKey() != Winning.NONE)
                              .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public double calculateRateOfReturn() {
        int  totalPurchasePrice = calculateTotalPurchasePrice();
        if (totalPurchasePrice == 0) {
            return 0;
        }
        return (double) calculateTotalPrize() / totalPurchasePrice;
    }

    private int calculateTotalPrize() {
        return winningCountMap.entrySet()
                              .stream()
                              .mapToInt(winningCount -> winningCount.getKey().getPrize() * winningCount.getValue())
                              .sum();
    }

    private int calculateTotalPurchasePrice() {
        int totalTicketCount = winningCountMap.values().stream().mapToInt(Integer::intValue).sum();
        return LottoTicket.PRICE * totalTicketCount;
    }
}
