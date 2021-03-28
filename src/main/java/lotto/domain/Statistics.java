package lotto.domain;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    private final Map<Rank, Integer> statistics;

    public Statistics(List<Rank> winningResults) {
        this.statistics = generate(winningResults);
    }

    private Map<Rank, Integer> generate(List<Rank> winningResults) {
        Map<Rank, Integer> result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, winningCount(rank, winningResults));
        }
        return result;
    }

    private Integer winningCount(Rank rank, List<Rank> winningResults) {
        return (int) winningResults.stream()
                .filter(v -> v.equals(rank))
                .count();
    }

    public Map<Rank, Integer> getStatistics() {
        return this.statistics;
    }

    public double yield(int purchaseAmount) {
        int totalPrizeMoney = this.statistics
                .keySet()
                .stream()
                .map(k -> k.prizeMoney(statistics.get(k)))
                .reduce(0, Integer::sum);

        return (double) totalPrizeMoney / purchaseAmount;
    }
}
