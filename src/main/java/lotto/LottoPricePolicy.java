package lotto;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum LottoPricePolicy {

    FIRST(6, 2_000_000_000, (matchCount, isBonusNumber) -> (matchCount == 6)),
    SECOND(5, 30_500_000, (matchCount, isBonusNumber) -> (matchCount == 5 && isBonusNumber)),
    THREE(5, 1_500_000, (matchCount, isBonusNumber) -> (matchCount == 5 && !isBonusNumber)),
    FOURTH(4, 50_000, (matchCount, isBonusNumber) -> (matchCount == 4)),
    FIFTH(3, 5_000, (matchCount, isBonusNumber) -> (matchCount == 3)),
    ETC(0, 0, (matchCount, isBonusNumber) -> (matchCount == 0));

    private final long matchCount;
    private final long winningAmount;
    private final BiFunction<Integer, Boolean, Boolean> condition;

    LottoPricePolicy(long matchCount, long winningAmount, BiFunction<Integer, Boolean, Boolean> condition) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.condition = condition;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

    public static LottoPricePolicy find(int matchCount, boolean isBonusNumber){
        return Arrays.stream(LottoPricePolicy.values())
                .filter(t -> t.condition.apply(matchCount, isBonusNumber))
                .findFirst()
                .orElse(ETC);
    }
}
