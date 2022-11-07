package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Statistics {

    private final Map<WinningType, Integer> statistics;

    public Statistics(Map<WinningType, Integer> winningResult) {
        statistics = new LinkedHashMap<>();
        for (WinningType winningType : WinningType.values()) {
            statistics.put(winningType, 0);
        }
        statistics.putAll(winningResult);
    }

    public Map<WinningType, Integer> getStatistics() {
        return statistics;
    }

    public double getRateOfReturn(Money money) {
        return Math.floor(getEarning() / money.getMoney() * 100) / 100;
    }

    private int getEarning() {
        int sum = 0;
        for (Map.Entry<WinningType, Integer> entry : statistics.entrySet()) {
            sum += entry.getKey().getWinningAmount() * entry.getValue();
        }
        return sum;
    }
}
