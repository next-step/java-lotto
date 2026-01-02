package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public final class WinningStatistics {
    private final Map<Rank, Integer> counts = new EnumMap<>(Rank.class);

    public WinningStatistics() {
        initCounts();
    }

    public void accumulate(List<Lotto> tickets, WinningNumbers winningNumbers) {
        tickets.forEach(ticket -> accumulateOne(ticket, winningNumbers));
    }

    public int countOf(Rank rank) {
        return counts.getOrDefault(rank, 0);
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

    private void accumulateOne(Lotto ticket, WinningNumbers winningNumbers) {
        Rank rank = winningNumbers.match(ticket);
        if (!rank.isWinning()) {
            return;
        }
        counts.put(rank, countOf(rank) + 1);
    }
}
