package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private final Map<Rank, Integer> counts = new EnumMap<>(Rank.class);

    public WinningStatistics() {
        initCounts();
    }

    public void accumulate(List<Lotto> lottos, Lotto winning) {
        lottos.forEach(lotto -> accumulateOne(lotto, winning));
    }

    public int countOf(Rank rank) {
        return counts.get(rank);
    }

    public long totalPrize() {
        return counts.entrySet().stream()
            .mapToLong(e -> e.getKey().prize() * e.getValue())
            .sum();
    }

    public double profitRate(Money purchase) {
        return (double) totalPrize() / purchase.amount();
    }

    private void initCounts() {
        for (Rank rank : Rank.winningRanks()) {
            counts.put(rank, 0);
        }
    }

    private void accumulateOne(Lotto lotto, Lotto winning) {
        Rank rank = Rank.of(lotto.matchCount(winning));
        if (!rank.isWinning()) {
            return;
        }
        counts.put(rank, counts.get(rank) + 1);
    }
}
