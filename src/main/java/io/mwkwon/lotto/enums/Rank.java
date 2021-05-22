package io.mwkwon.lotto.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6),
    SECOND(5),
    THIRD(4),
    FIFTH(3),
    MISS(0);

    private static Map<Integer, Rank> ENUM_MAP;

    private int matchCount;

    static {
        ENUM_MAP = Stream.of(Rank.values()).collect(Collectors.toMap(Rank::getMatchCount, Function.identity()));
    }

    Rank(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static Rank getRankByMatchCount(int matchCount) {
        return ENUM_MAP.getOrDefault(matchCount, MISS);
    }
}
