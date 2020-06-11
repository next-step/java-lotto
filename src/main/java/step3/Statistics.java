package step3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private static final Map<Integer, Integer> statistics = new HashMap<>();

    public Statistics() {
        for (WinningStatistics value : WinningStatistics.values()) {
            statistics.put(value.getMatchedNumberCount(), 0);
        }
    }
    public Statistics(List<Integer> winningCountList) {
        this();

        winningCountList.stream().filter(statistics::containsKey).forEach(key -> {
            int count = statistics.get(key);
            statistics.put(key, ++count);
        });
    }

    public Map<Integer, Integer> getStatistics() {
        return statistics;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Map.Entry<Integer, Integer> entry : statistics.entrySet()) {
            WinningStatistics winningStatistics = WinningStatistics.valueOfWinningCount(entry.getKey());
            totalPrice += getPrice(winningStatistics.getWinningPrice(), entry.getValue());
        }

        return totalPrice;
    }

    private int getPrice(int price, int count) {
        if (count >= 1) {
            return price;
        }

        return 0;
    }
}
