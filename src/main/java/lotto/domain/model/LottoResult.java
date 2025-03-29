package lotto.domain.model;

import java.util.*;

public class LottoResult {
    private final Map<Rank, Integer> rankCounts = new HashMap<>();

    public void addResult(final Rank rank) {
        rankCounts.merge(rank, 1, Integer::sum);
    }

    public Map<Rank, Integer> getRankCounts() {
        return Collections.unmodifiableMap(rankCounts);
    }

    public int getTotalPrize() {
        return Arrays.stream(Rank.values())
                .map(rank -> rankCounts.getOrDefault(rank, 0) * rank.getWinningPrize())
                .reduce(0, Integer::sum);
    }

    public double calculateYield(final int purchaseAmount) {
        return (double) getTotalPrize() / purchaseAmount;
    }
}
