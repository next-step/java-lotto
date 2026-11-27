package domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {

    private final Map<Rank, Integer> rankCounts;

    public WinningStatistics(List<Rank> ranks) {
        this(create(ranks));
    }

    public WinningStatistics(Rank... ranks) {
        this(create(Arrays.stream(ranks).toList()));
    }

    public WinningStatistics(Map<Rank, Integer> rankCounts) {
        this.rankCounts = rankCounts;
    }


    private static Map<Rank, Integer> create(List<Rank> ranks) {
        Map<Rank, Integer> counts = new EnumMap<>(Rank.class);
        for (Rank rank : ranks) {
            counts.merge(rank, 1, Integer::sum);
        }
        return counts;
    }

    public int countOf(Rank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    public long totalPrize() {
        long total = 0;
        for (Rank rank : rankCounts.keySet()) {
            total += rank.prize(countOf(rank));
        }
        return total;
    }

    public double profitRate(int amount) {
        return (double) totalPrize() / amount;
    }
}