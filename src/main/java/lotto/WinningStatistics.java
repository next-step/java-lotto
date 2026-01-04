package lotto;

import java.util.EnumMap;
import java.util.Map;

public final class WinningStatistics {
    private final Map<Rank, Integer> counts = new EnumMap<>(Rank.class);

    public void accumulate(Rank rank) {
        counts.merge(rank, 1, Integer::sum);
    }

    public int countOf(Rank rank) {
        return counts.getOrDefault(rank, 0);
    }

    public long totalPrize() {
        long sum = 0L;
        for (Map.Entry<Rank, Integer> e : counts.entrySet()) {
            sum += (long) e.getKey().prize() * e.getValue();
        }
        return sum;
    }

    public int countOf(Rank rank) {
        return counts.get(rank);
    }
}
