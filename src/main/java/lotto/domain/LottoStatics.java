package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStatics {
    private static final int REVENUE_START = 0;
    private static final int MAP_DEFAULT = 0;

    private int cost;
    private Map<Integer, Integer> statistics;

    public LottoStatics(int cost, List<Integer> result) {
        this.cost = cost;
        this.statistics = createStatistics(result);
    }

    public Map<Integer, Integer> getStatistics() {
        return statistics;
    }

    private Map<Integer, Integer> createStatistics(List<Integer> result) {
        Map<Integer, Integer> statistics = initStatistics();

        result.stream().filter(r -> r > 2).forEach(r -> statistics.put(r, statistics.get(r) + 1));

        return statistics;
    }

    private Map<Integer, Integer> initStatistics() {
        Map<Integer, Integer> statistics = new HashMap<>();

        Rank.getCountList().stream().forEach(i -> statistics.put(i, 0));

        return statistics;
    }

    public String getRate() {
        float revenue = REVENUE_START;
        for(int matchNumber: Rank.getCountList()) {
            revenue += (statistics.getOrDefault(matchNumber, MAP_DEFAULT) * Rank.of(matchNumber));
        }

        return String.valueOf(Math.floor((revenue / (float)cost) * 100) / 100.0);
    }
}
