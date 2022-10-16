package step2.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class CountsByRank {
    private final Map<Rank, Long> countsByRank;

    public CountsByRank(Map<Rank, Long> countsByRank) {
        this.countsByRank = countsByRank;
    }

    public CountsByRank mergeEmptyRank() {
        TreeMap<Rank, Long> countAllRanks = new TreeMap<>(this.countsByRank);
        Arrays.stream(Rank.values())
                .filter(rank -> !countAllRanks.containsKey(rank))
                .forEach(rank -> countAllRanks.put(rank, 0L));
        return new CountsByRank(countAllRanks);
    }

    public long totalRevenue() {
        return countsByRank.entrySet().stream()
                .map(entries -> entries.getKey().getWinningMoney() * entries.getValue() / 1000)
                .reduce(0L, Long::sum);
    }

    public CountsByRank sortByDesc() {
        Map<Rank, Long> descMap = new TreeMap<>(Collections.reverseOrder());
        descMap.putAll(countsByRank);
        return new CountsByRank(descMap);
    }

    public Map<Rank, Long> getCountsByRank() {
        return countsByRank;
    }
}
