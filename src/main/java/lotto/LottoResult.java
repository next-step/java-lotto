package lotto;

import java.util.List;

public class LottoResult {
    private List<Rank> ranks;
    private long purchaseAmount;

    public LottoResult(List<Rank> ranks, long purchaseAmount) {
        this.ranks = ranks;
        this.purchaseAmount = purchaseAmount;
    }

    private long getTotalPrize() {
        return ranks.stream()
                .mapToLong(Rank::getPrize)
                .sum();
    }

    public double getTotalPrizeRate() {
        return (double) getTotalPrize() / purchaseAmount;
    }

    public long getRankCount(Rank rank) {
        return ranks.stream()
                .filter(r -> r == rank)
                .count();
    }
}
