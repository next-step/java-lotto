package io.mwkwon.lotto.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2_000_000_000, "%s개 일치 (%s원) - %s개"),
    SECOND(5, 30_000_000, "%s개 일치, 보너스볼 일치(%s원) - %s개"),
    THIRD(5, 1_500_000, "%s개 일치 (%s원) - %s개"),
    FOURTH(4, 50_000, "%s개 일치 (%s원) - %s개"),
    FIFTH(3, 5_000, "%s개 일치 (%s원) - %s개"),
    MISS(0, 0, "%s개 이하 일치 (%s원) - %s개");

    private static Map<Integer, Rank> ENUM_MAP;

    private final int matchCount;
    private final int reward;
    private final String statisticsMessage;

    static {
        ENUM_MAP = Stream.of(Rank.values())
                .filter(rank -> rank != Rank.SECOND)
                .collect(Collectors.toMap(Rank::getMatchCount, Function.identity()));
    }

    Rank(int matchCount, int reward, String statisticsMessage) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.statisticsMessage = statisticsMessage;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public String getStatisticsMessage() {
        return statisticsMessage;
    }

    public static Rank valueOf(int matchCount, boolean isMatchBonus) {
        if (matchCount == 5 && isMatchBonus) {
            return Rank.SECOND;
        }
        return ENUM_MAP.getOrDefault(matchCount, MISS);
    }

    public static List<Rank> createPrintTargetRank() {
        return Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }
}
