package me.devyonghee.lotto.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public enum Rank {

    FIRST(2_000_000_000, Lotto.NUMBER_SIZE, false, Condition.MATCH_COUNT),
    SECOND(30_000_000, Lotto.NUMBER_SIZE - 1, true, Condition.MATCH_COUNT_WITH_BONUS),
    THIRD(1_500_000, Lotto.NUMBER_SIZE - 1, false, Condition.MATCH_COUNT_WITH_BONUS),
    FOURTH(50_000, Lotto.NUMBER_SIZE - 2, false, Condition.MATCH_COUNT),
    FIFTH(5_000, Lotto.NUMBER_SIZE - 3, false, Condition.MATCH_COUNT),
    NOTHING(0, Lotto.NUMBER_SIZE - 3, false, Condition.LESS_THAN);

    private final int prize;
    private final int matchCount;
    private final boolean matchedBonus;
    private final Condition condition;

    Rank(int prize, int matchCount, boolean matchedBonus, Condition condition) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.matchedBonus = matchedBonus;
        this.condition = condition;
    }

    static Rank of(long matchCount, boolean hasBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.condition.test(rank.matchCount, matchCount, rank.matchedBonus == hasBonus))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("rank is not exists for match count(%d)", matchCount)));
    }

    public int prize() {
        return prize;
    }

    public int matchCount() {
        return matchCount;
    }

    public boolean matchedBonus() {
        return matchedBonus;
    }

    private enum Condition {
        MATCH_COUNT_WITH_BONUS((count, target) -> hasBonus -> Objects.equals(count, target) && hasBonus),
        MATCH_COUNT((count, target) -> hasBonus -> Objects.equals(count, target)),
        LESS_THAN((count, target) -> hasBonus -> target < count);

        private final BiFunction<Long, Long, Predicate<Boolean>> predicate;

        Condition(BiFunction<Long, Long, Predicate<Boolean>> predicate) {
            this.predicate = predicate;
        }

        boolean test(long count, long target, boolean hasBonus) {
            return predicate.apply(count, target)
                    .test(hasBonus);
        }
    }
}
