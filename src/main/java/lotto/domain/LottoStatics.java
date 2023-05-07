package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatics {
    private static final int MAP_DEFAULT = 0;
    private static final int LOTTO_MATCH_COUNT = 1;
    private static final int LOTTO_REWARD_LIMIT = 3;

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

        result.stream()
                .filter(r -> r >= LOTTO_REWARD_LIMIT)
                .forEach(r -> statistics.put(r, statistics.get(r) + LOTTO_MATCH_COUNT));

        return statistics;
    }

    private Map<Integer, Integer> initStatistics() {
        Map<Integer, Integer> statistics = new HashMap<>();

        Rank.getCountList().stream().forEach(i -> statistics.put(i, MAP_DEFAULT));

        return statistics;
    }

    public String getRate() {
        int revenue = Rank.getCountList().stream().mapToInt(count -> statistics.get(count) * Rank.of(count)).sum();

        return String.valueOf(Math.floor(((float)revenue / (float)cost) * 100) / 100.0);
    }
}
