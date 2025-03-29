package domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoStatistics {
    private final Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);

    public LottoStatistics(List<Rank> ranks) {
        ranks.stream()
                .filter(Objects::nonNull)
                .forEach(rank -> statistics.put(rank, statistics.getOrDefault(rank, 0) + 1)
        );
    }

    public int getCountByRank(Rank rank) {
        return statistics.getOrDefault(rank, 0);
    }

    public double calculateProfitRate(int purchaseAmount) {
        return (double) getTotalPrize() / purchaseAmount;
    }

    private int getTotalPrize() {
        return statistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}