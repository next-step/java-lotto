package lotto.model.domain;

import java.util.*;

public final class Ranks {

    private final List<Rank> ranks;

    private Ranks(final List<Rank> ranks) {
        this.ranks = ranks;
    }

    public static Ranks of(final List<Rank> ranks) {
        return new Ranks(ranks);
    }

    public Map<Rank, Integer> allCounts() {
        final Map<Rank, Integer> ranksCount = new EnumMap<>(Rank.class);
        ranks.forEach(rank -> ranksCount.putIfAbsent(rank, count(rank)));
        return Collections.unmodifiableMap(ranksCount);
    }

    private int count(final Rank rank) {
        return (int) ranks.stream()
                .filter(value -> value.equals(rank))
                .count();
    }
}
