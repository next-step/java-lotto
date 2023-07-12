package domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Long> rankCount = new EnumMap<>(Rank.class);

    public LottoResult(final List<Rank> ranks) {
        ranks.forEach(this::increaseRankCount);
    }

    private long calculateTotalPrize() {
        return rankCount.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private void increaseRankCount(final Rank rank) {
        rankCount.put(rank, getCount(rank) + 1);
    }

    public Long getCount(final Rank rank) {
        return rankCount.getOrDefault(rank, 0L);
    }

    public double calculateRateOfReturn(final long money) {
        return calculateTotalPrize() / (double) money;
    }
}
