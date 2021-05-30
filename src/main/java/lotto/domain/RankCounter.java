package lotto.domain;

import lotto.domain.entity.Rank;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RankCounter {

    private final Map<Rank, Integer> counter = new HashMap<>();

    public void addCount(Rank rank) {
        int count = counter.get(rank) != null
                ? counter.get(rank) + 1
                : 1;
        counter.put(rank, count);
    }

    public Integer countByRank(Rank rank) {
        return counter.get(rank);
    }

    public Map<Rank, Integer> counter() {
        return counter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RankCounter that = (RankCounter) o;
        return Objects.equals(counter, that.counter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(counter);
    }

    @Override
    public String toString() {
        return "RankCounter{" +
                "counter=" + counter +
                '}';
    }
}
