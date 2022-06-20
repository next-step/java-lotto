package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CountByRank {
    private final Map<Rank, Integer> countByRank;

    public CountByRank(Map<Rank, Integer> countByRank) {
        this.countByRank = countByRank;
    }

    public static CountByRank create() {
        Map<Rank, Integer> rankIntegerMap = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankIntegerMap.put(rank, 0);
        }
        return new CountByRank(rankIntegerMap);
    }

    public CountByRank increaseCount(Rank rank) {
        Map<Rank, Integer> increasedCountByRank = new HashMap<>(countByRank);
        increasedCountByRank.replace(rank, increasedCountByRank.get(rank) + 1);
        return new CountByRank(increasedCountByRank);
    }

    public int count(Rank rank) {
        return countByRank.get(rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountByRank that = (CountByRank) o;
        return countByRank.equals(that.countByRank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countByRank);
    }
}
