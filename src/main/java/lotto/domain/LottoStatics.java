package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatics {
    private static final int MAP_DEFAULT = 0;
    private static final int LOTTO_MATCH_COUNT = 1;

    private final int cost;
    private Map<WinningCount, Integer> statistics;

    public LottoStatics(int cost, List<WinningCount> result) {
        this.cost = cost;
        this.statistics = createStatistics(result);
    }

    public Map<WinningCount, Integer> getStatistics() {
        return statistics;
    }

    private Map<WinningCount, Integer> createStatistics(List<WinningCount> result) {
        Map<WinningCount, Integer> statistics = initStatistics();

        result.stream()
                .forEach(winningCount -> statistics.put(winningCount, statistics.get(winningCount) + LOTTO_MATCH_COUNT));

        return statistics;
    }

    private Map<WinningCount, Integer> initStatistics() {
        Map<WinningCount, Integer> statistics = new HashMap<>();

        Rank.getWinningCounts().stream().forEach(winningCount -> statistics.put(winningCount, MAP_DEFAULT));

        return statistics;
    }

    public String getRate() {
        int revenue = Rank.getWinningCounts().stream()
                .mapToInt(winningCount -> statistics.get(winningCount) * Rank.of(winningCount))
                .sum();

        return String.valueOf(Math.floor(((float)revenue / (float)cost) * 100) / 100.0);
    }
}
