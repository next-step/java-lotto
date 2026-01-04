package lotto;

import java.util.EnumMap;
import java.util.Map;

public final class WinningStatistics {
    private final Map<Rank, Integer> counts = new EnumMap<>(Rank.class);

    public WinningStatistics() {
        initialize();
    }

    private void initialize() {
        for (Rank rank : Rank.values()) {
            counts.put(rank, 0);
        }
    }

    public void accumulate(Rank rank) {
        counts.put(rank, counts.get(rank) + 1);
    }

    // (선택) 혹시 기존 코드가 add를 쓰고 있다면 호환용으로 남겨도 됨
    public void add(Rank rank) {
        accumulate(rank);
    }

    public int countOf(Rank rank) {
        return counts.get(rank);
    }

    public long totalPrize() {
        long total = 0;
        for (Rank rank : Rank.values()) {
            total += (long) rank.prize() * counts.get(rank);
        }
        return total;
    }

    public double profitRate(Money purchaseAmount) {
        return (double) totalPrize() / purchaseAmount.amount();
    }
}
