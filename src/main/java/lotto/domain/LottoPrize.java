package lotto.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum LottoPrize {
    FIRST(6, 2_000_000_000, (count, bonus) -> count == 6),
    SECOND(5, 30_000_000, (count, bonus) -> count == 5 && bonus),
    THIRD(5, 1_500_000, (count, bonus) -> count == 5 && !bonus),
    FOURTH(4, 50_000, (count, bonus) -> count == 4),
    FIFTH(3, 5_000, (count, bonus) -> count == 3),
    NONE(0, 0, (count, bonus) -> count < 3);

    private final int matchCount;
    private final int prize;
    private final BiFunction<Integer, Boolean, Boolean> condition;

    private static int MIN_MATCH = 3;

    LottoPrize(int matchCount, int prize, BiFunction<Integer, Boolean, Boolean> condition) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.condition = condition;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return this.prize;
    }

    public static LottoPrize find(int count, boolean bonus) {
        return Arrays.stream(values())
                .filter(prize -> prize.condition.apply(count, bonus))
                .findFirst().get();
    }

    public static LottoPrize from(int count) {
        if (count < MIN_MATCH) {
            return NONE;
        }
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == count)
                .findFirst().get();
    }
}
