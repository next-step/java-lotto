package lotto.result;

import lotto.domain.Rank;

import java.util.EnumMap;
import java.util.Map;

public class LottoMatchResult {
    private final Map<Rank, Integer> results;

    public LottoMatchResult() {
        this(new EnumMap<>(Rank.class));
    }

    public LottoMatchResult(Rank... ranks) {
        this(toEnumMaps(ranks));
    }

    private static Map<Rank, Integer> toEnumMaps(Rank... ranks) {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);
        for (Rank rank : ranks) {
            results.merge(rank, 1, Integer::sum);
        }
        return results;
    }

    public LottoMatchResult(Map<Rank, Integer> results) {
        this.results = results;
    }

    public void updateRank(Rank rank) {
        results.merge(rank, 1, Integer::sum);
    }

    public int totalPrize() {
        return results.entrySet().stream()
                .map(this::calculatePrize)
                .reduce(0, Integer::sum);
    }

    private int calculatePrize(Map.Entry<Rank, Integer> entry) {
        Rank rank = entry.getKey();
        int count = entry.getValue().intValue();
        return rank.totalPrize(count);
    }

    private long count(Rank rank) {
        return results.getOrDefault(rank, 0);
    }

    @Override
    public String toString() {
        return "LottoMatchResult{" +
                "results=" + results +
                '}';
    }
}
