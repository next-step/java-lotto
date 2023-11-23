package lotto.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Ranking {
    FIRST(6, 2000000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NOT_RANKED(0, 0);
    private final int matchingCount;
    private final int profit;
    private static final Map<Integer, Ranking> MATCHING_COUNT_MAP =Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(o -> o.matchingCount, o -> o)));

    Ranking(int matchingCount, int profit) {
        this.matchingCount = matchingCount;
        this.profit = profit;
    }

    public static Ranking of(int matchingCount) {
        return MATCHING_COUNT_MAP.get(matchingCount);
    }

    public int matchingCount() {
        return matchingCount;
    }

    public int profit() {
        return profit;
    }

    public static List<Ranking> ranked() {
        return Stream.of(values()).filter(rank -> rank != Ranking.NOT_RANKED).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
}
