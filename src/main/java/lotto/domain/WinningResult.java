package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    private static final int DEFAULT_VALUE = 0;
    private static final int UPDATE_VALUE = 1;
    private static final double TICKET_PRICE = 1000l;

    private Map<Rank, Integer> result;
    private double count = 0d;

    public WinningResult() {
        this.result = new EnumMap<>(Rank.class);
    }

    public WinningResult updateRank(List<Long> winnerCount) {
        for (Long count : winnerCount) {
            Rank rank = Rank.equalToCount(count);
            result.put(rank, result.getOrDefault(rank, DEFAULT_VALUE) + UPDATE_VALUE);
            this.count = this.count + UPDATE_VALUE;
        }
        return this;
    }

    public double getMoney() {
        return count * TICKET_PRICE;
    }

    public double getPrizeMoney() {
        return (double) result.keySet()
            .stream()
            .mapToLong(key -> key.getPrizeMoney() * result.get(key))
            .sum();
    }

    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
