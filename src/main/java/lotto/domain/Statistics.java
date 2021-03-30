package lotto.domain;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Statistics {
    private final Map<Rank, Integer> statistics;

    public Statistics(List<Rank> winningResults) {
        this(mappingResults(winningResults));
    }

    public Statistics(Map<Rank, Integer> statistics) {
        this.statistics = statistics;
    }

    private static Map<Rank, Integer> mappingResults(List<Rank> winningResults) {
        return Arrays.stream(Rank.values())
                .collect(Collectors.toMap(rank -> rank
                        , rank -> winningCount(rank, winningResults)
                        , (e1, e2) -> e1
                        , LinkedHashMap::new
                ));
    }

    private static Integer winningCount(Rank rank, List<Rank> winningResults) {
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
