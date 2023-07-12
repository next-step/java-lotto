package domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Long> rankCount = new EnumMap<>(Rank.class);

    public LottoResult(final List<Rank> ranks) {
        ranks.forEach(this::increaseRankCount);
    }

    public Long countRank(final Rank rank) {
        return rankCount.getOrDefault(rank, 0L);
    }

    public double calculateRateOfReturn(final long money) {
        return calculateTotalPrize() / (double) money;
    }

    private void increaseRankCount(final Rank rank) {
        rankCount.put(rank, countRank(rank) + 1);
    }

    private long calculateTotalPrize() {
        return Arrays.stream(Rank.values())
                .mapToLong(this::calculatePrize)
                .sum();
    }

    private long calculatePrize(final Rank rank) {
        return rank.getPrize() * countRank(rank);
    }
}
