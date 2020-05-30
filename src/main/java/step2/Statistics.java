package step2;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private Map<Integer, Integer> statisticsMap;

    public Statistics() {
        this.statisticsMap = new HashMap<>();
        initMap();
    }

    public Map<Integer, Integer> getStatisticsMap() {
        return statisticsMap;
    }

    public void addCount(int winningCount) {
        if (!statisticsMap.containsKey(winningCount)) {
            return;
        }

        Integer count = statisticsMap.get(winningCount);
        statisticsMap.put(winningCount, ++count);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Map.Entry<Integer, Integer> entry : statisticsMap.entrySet()) {
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
            statisticsMap.put(value.getMatchedNumberCount(), 0);
        }
    }
}
