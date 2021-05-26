package io.mwkwon.lotto.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6,
            2_000_000_000,
            "%s개 일치 (%s원) - %s개",
            (matchCount, isMatchBonusNumber) -> matchCount == 6),
    SECOND(5,
            30_000_000,
            "%s개 일치, 보너스볼 일치(%s원) - %s개",
            (matchCount, isMatchBonusNumber) -> matchCount == 5 && isMatchBonusNumber),
    THIRD(5,
            1_500_000,
            "%s개 일치 (%s원) - %s개",
            (matchCount, isMatchBonusNumber) -> matchCount == 5 && !isMatchBonusNumber),
    FOURTH(4,
            50_000,
            "%s개 일치 (%s원) - %s개",
            (matchCount, isMatchBonusNumber) -> matchCount == 4),
    FIFTH(3,
            5_000,
            "%s개 일치 (%s원) - %s개",
            (matchCount, isMatchBonusNumber) -> matchCount == 3),
    MISS(0,
            0,
            "%s개 이하 일치 (%s원) - %s개",
            (matchCount, isMatchBonusNumber) -> matchCount >= 0 && matchCount < 3);

    private static List<Rank> RANKS;

    private final int matchCount;
    private final int reward;
    private final String statisticsMessage;
    private final BiPredicate<Long, Boolean> rankCondition;

    static {
        RANKS = Stream.of(Rank.values()).collect(Collectors.toList());
    }

    Rank(int matchCount, int reward, String statisticsMessage, BiPredicate<Long, Boolean> rankCondition) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.statisticsMessage = statisticsMessage;
        this.rankCondition = rankCondition;
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

    public static Rank matchRank(long matchCount, boolean isMatchBonus) {
        return RANKS.stream()
                .filter(rank -> rank.rankCondition.test(matchCount, isMatchBonus))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static List<Rank> createPrintTargetRank() {
        return Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }
}
