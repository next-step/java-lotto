package lotto.domain;

import lotto.enums.Rank;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ranks {
    private final List<Rank> results;

    public Ranks(List<Rank> result) {
        this.results = result;
    }

    long getPriceTotal() {
        long result = 0;
        for (Rank rank : this.results) {
            result += rank.getPrice();
        }
        return result;
    }

    public int getWinnerCount(Rank rank) {
        return (int) results.stream()
                .filter(result -> result == rank)
                .count();
    }

    public int getSize() {
        return results.size();
    }

    public List<Rank> getResults() {
        return Collections.unmodifiableList(results);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranks ranks = (Ranks) o;
        return Objects.equals(results, ranks.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
