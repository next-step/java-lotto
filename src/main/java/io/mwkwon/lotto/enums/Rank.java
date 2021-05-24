package io.mwkwon.lotto.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private static Map<Integer, Rank> ENUM_MAP;

    private final int matchCount;
    private final int reward;

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

    public static List<Rank> createPrintTargetRank() {
        return Arrays.asList(FOURTH, THIRD, SECOND, FIRST);
    }
}
