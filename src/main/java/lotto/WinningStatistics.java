package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private final Map<Rank, Integer> counts = new EnumMap<>(Rank.class);

    public WinningStatistics() {
        for (Rank rank : Rank.values()) {
            counts.put(rank, 0);
        }
    }

    public void accumulate(List<Lotto> lottos, WinningNumbers winningNumbers) {
        lottos.forEach(lotto -> accumulateOne(lotto, winningNumbers));
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

    private void accumulateOne(Lotto lotto, WinningNumbers winningNumbers) {
        int match = lotto.matchCount(winningNumbers);
        if (!Rank.isWinning(match)) {
            return;
        }
        Rank rank = Rank.from(match);
        counts.put(rank, counts.get(rank) + 1);
    }
}
