package step2.domain;


import java.util.*;

public class CountsByRank {
    private final Map<Rank, Long> countsByRank;

    public CountsByRank(Map<Rank, Long> countsByRank) {
        Map<Rank, Long> countAllRanks = mergeEmptyRank(countsByRank);
        this.countsByRank = sortByDesc(countAllRanks);
    }

    public long totalRevenue() {
        return countsByRank.entrySet().stream()
                .map(entries -> entries.getKey().getWinningMoney() * entries.getValue() / 1000)
                .reduce(0L, Long::sum);
    }

    public CountsByRank filter(List<Rank> excludeRanks) {
        excludeRanks.forEach(countsByRank::remove);
        return this;
    }

    private Map<Rank, Long> mergeEmptyRank(Map<Rank, Long> countsByRank) {
        TreeMap<Rank, Long> countAllRanks = new TreeMap<>(countsByRank);
        Arrays.stream(Rank.values())
                .filter(rank -> !countAllRanks.containsKey(rank))
                .forEach(rank -> countAllRanks.put(rank, 0L));
        return countAllRanks;
    }

    private Map<Rank, Long> sortByDesc(Map<Rank, Long> countAllRanks) {
        Map<Rank, Long> descMap = new TreeMap<>(Collections.reverseOrder());
        descMap.putAll(countAllRanks);
        return descMap;
    }

    public Map<Rank, Long> getCountsByRank() {
        return countsByRank;
    }
}
