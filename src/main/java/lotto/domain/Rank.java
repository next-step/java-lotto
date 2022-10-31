package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.function.BiPredicate;

public enum Rank {

    FIRST(2_000_000_000, 6, (matchCount, hasBonusBall) -> matchCount == 6),
    SECOND(30_000_000, 5, (matchCount, hasBonusBall) -> matchCount == 5 && hasBonusBall),
    THIRD(1_500_000, 5, (matchCount, hasBonusBall) -> matchCount == 5 && !hasBonusBall),
    FOURTH(50_000, 4, (matchCount, hasBonusBall) -> matchCount == 4),
    FIFTH(5_000, 3, (matchCount, hasBonusBall) -> matchCount == 3),
    LOSER(0, 0, (matchCount, hasBonusBall) -> matchCount < 3);

    private final int reward;
    private final int matchCount;
    private final BiPredicate<Integer, Boolean> condition;

    Rank(int reward, int matchCount, BiPredicate<Integer, Boolean> condition) {
        this.reward = reward;
        this.matchCount = matchCount;
        this.condition = condition;
    }

    static Rank valueOf(int matchCount, boolean hasBonusBall) {
        return Arrays.stream(values())
            .filter(rank -> rank.condition.test(matchCount, hasBonusBall))
            .findFirst()
            .orElse(LOSER);
    }

    public int matchCount() {
        return matchCount;
    }

    static double yield(EnumMap<Rank, Integer> rankIntegerEnumMap, int purchaseMoney) {
        double sum = rankIntegerEnumMap.entrySet().stream()
            .mapToDouble(rankIntegerEntry -> (double) rankIntegerEntry.getValue() * rankIntegerEntry.getKey().reward)
            .sum();
        return sum / purchaseMoney;
    }

    public int reward() {
        return reward;
    }
}
