package lotto.constant;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public enum Prize {
    FIFTH(3, 5_000, (count, isBonusMatch) -> count == 3),
    FOURTH(4, 50_000, (count, isBonusMatch) -> count == 4),
    THIRD(5, 1_500_000, (count, isBonusMatch) -> count == 5 && !isBonusMatch),
    SECOND(5, 30_000_000, (count, isBonusMatch) -> count == 5 && isBonusMatch),
    FIRST(6, 2_000_000_000, (count, isBonusMatch) -> count == 6),
    MISS(0, 0, (count, isBonusMatch) -> count < 3);

    private final int matchCount;
    private final int prizeMoney;
    private final BiPredicate<Integer, Boolean> expression;

    Prize(int matchCount, int prizeMoney, BiPredicate<Integer, Boolean> expression) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.expression = expression;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Prize valueOf(int matchCount) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElse(MISS);
    }

    public static Prize calculateRank(int count, boolean isBonusMatch) {
        return Arrays.stream(values())
                .filter(prize -> prize.expression.test(count, isBonusMatch))
                .findFirst()
                .orElse(MISS);
    }
}
