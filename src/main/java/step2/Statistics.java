package step2;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private Map<Integer, Integer> statistics = new HashMap<>();

    public Statistics() {
        initMap();
    }

    public Map<Integer, Integer> getStatistics() {
        return statistics;
    }

    public void addCount(int winningCount) {
        if (!statistics.containsKey(winningCount)) {
            return;
        }

        Integer count = statistics.get(winningCount);
        statistics.put(winningCount, ++count);
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

    private void initMap() {
        for (WinningStatistics value : WinningStatistics.values()) {
            statistics.put(value.getMatchedNumberCount(), 0);
        }
    }
}
