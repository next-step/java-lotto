package lotto.domain;

import lotto.domain.winning.Rank;
import lotto.domain.winning.WinningCount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private static final int MAP_DEFAULT = 0;
    private static final int LOTTO_MATCH_COUNT = 1;

    private final int cost;
    private Map<WinningCount, Integer> statistics;

    public LottoStatistics(int cost) {
        this.cost = cost;
        this.statistics = initStatistics();
    }

    public LottoStatistics(int cost, List<WinningCount> result) {
        this.cost = cost;

        this.statistics = registerStatistics(result);
    }

    public Map<WinningCount, Integer> getStatistics() {
        return statistics;
    }

    private Map<WinningCount, Integer> registerStatistics(List<WinningCount> result) {
        Map<WinningCount, Integer> statistics = initStatistics();
        result.stream()
                .filter(WinningCount::isRewardWinningCount)
                .forEach(winningCount -> statistics.put(winningCount, statistics.get(winningCount) + LOTTO_MATCH_COUNT));

        return statistics;
    }

    private Map<WinningCount, Integer> initStatistics() {
        Map<WinningCount, Integer> statistics = new HashMap<>();

        Rank.getWinningCounts().stream().forEach(winningCount -> statistics.put(winningCount, MAP_DEFAULT));

        return statistics;
    }

    public String getRate() {
        int revenue = calculateRevenue();

        return String.valueOf(Math.floor(((float)revenue / (float)cost) * 100) / 100.0);
    }

    private int calculateRevenue() {
        return Rank.getWinningCounts().stream()
                .mapToInt(winningCount -> statistics.get(winningCount) * Rank.of(winningCount))
                .sum();
    }
}
