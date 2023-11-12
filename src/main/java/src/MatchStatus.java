package src;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class MatchStatus {

    private final Map<WinningAmount, Integer> status;

    private final double profit;

    private MatchStatus(Map<WinningAmount, Integer> status, double profit) {
        this.status = status;
        this.profit = profit;
    }

    public static MatchStatus matchStatus(List<Integer> matchCounts) {
        Map<WinningAmount, Integer> status = new EnumMap<>(WinningAmount.class);
        for (Integer matchCount: matchCounts) {
            WinningAmount winningAmount = WinningAmount.byMatchedCount(matchCount);
            Integer winningGameCount = status.getOrDefault(winningAmount, 0);
            status.put(winningAmount, winningGameCount + 1);
        }

        return new MatchStatus(status, calculateProfit(status));
    }

    private static double calculateProfit(Map<WinningAmount, Integer> status) {
        double profit = 0.0;
        for (Map.Entry<WinningAmount, Integer> entry: status.entrySet()) {
            profit += entry.getKey().amount * entry.getValue();
        }

        return profit;
    }

    public Map<WinningAmount, Integer> status() {
        return status;
    }

    public double profit() {
        return profit;
    }
}
