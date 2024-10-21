package lottogame.domain.lotto;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private final Map<Rank, Integer> rankCounts;

    public WinningResult(Map<Rank, Integer> rankCounts) {
        this.rankCounts =  new EnumMap<>(rankCounts);
    }

    public double calculateTotalPrizeAmount() {
        return rankCounts.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    public int getCountForRank(Rank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    public Map<Rank, Integer> getRankCounts() {
        return Collections.unmodifiableMap(rankCounts);
    }


}
