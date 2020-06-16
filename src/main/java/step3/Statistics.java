package step3;

import step3.util.MathUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private static final Map<WinningStatistics, Integer> statistics = new HashMap<>();
    private static final int LOTTO_PRICE = 1000;

    private Statistics() {
        for (WinningStatistics value : WinningStatistics.values()) {
            statistics.put(value, 0);
        }
    }

    public Statistics(List<Integer> winningCountList) {
        this();

        winningCountList.stream()
                .filter(WinningStatistics::matchedCount)
                .forEach(winningCount -> {
                    WinningStatistics key = WinningStatistics.valueOfWinningCount(winningCount);
                    int value = statistics.get(key);
                    statistics.put(key, ++value);
                });
    }

    public Map<WinningStatistics, Integer> getStatistics() {
        return statistics;
    }

    public double calculateYield(int lottoTicketCount) {
        return MathUtils.calculateYield(getTotalPrice(), lottoTicketCount * LOTTO_PRICE);
    }

    private int getTotalPrice() {
        return statistics.entrySet().stream()
                .filter(entry -> entry.getValue() >= 1)
                .map(entry -> entry.getKey().getWinningMoney())
                .reduce(0, Integer::sum);
    }
}
