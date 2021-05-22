package io.mwkwon.lotto.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private static Map<Integer, Rank> ENUM_MAP;

    private int matchCount;
    private int reward;

    static {
        ENUM_MAP = Stream.of(Rank.values()).collect(Collectors.toMap(Rank::getMatchCount, Function.identity()));
    }

    Rank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public static Rank getRankByMatchCount(int matchCount) {
        return ENUM_MAP.getOrDefault(matchCount, MISS);
    }
}
