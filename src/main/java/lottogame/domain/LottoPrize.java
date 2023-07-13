package lottogame.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

enum LottoPrize {

    FIRST(2_000_000_000, 6, (matchedCount, isBonusMatched) -> matchedCount == 6),

    SECOND(30_000_000, 5, (matchedCount, isBonusMatched) -> matchedCount == 5 && isBonusMatched),

    THIRD(1_500_000, 5, (matchedCount, isBonusMatched) -> matchedCount == 5 && !isBonusMatched),

    FORTH(50_000, 4, (matchedCount, isBonusMatched) -> matchedCount == 4),

    FIFTH(5_000, 3, (matchedCount, isBonusMatched) -> matchedCount == 3),

    NONE(0, 0, (matchedCount, isBonusMatched) -> matchedCount < 3),
    ;

    private final int money;
    private final int matchedCount;
    private final BiPredicate<Integer, Boolean> lottoPrizePredicate;

    LottoPrize(int money, int matchedCount, BiPredicate<Integer, Boolean> lottoPrizePredicate) {
        this.money = money;
        this.matchedCount = matchedCount;
        this.lottoPrizePredicate = lottoPrizePredicate;
    }

    static LottoPrize of(int matchedCount, boolean isBonusMatched) {
        return Arrays.stream(LottoPrize.values()).sequential()
            .filter(lottoPrize -> lottoPrize.lottoPrizePredicate.test(matchedCount, isBonusMatched))
            .findFirst()
            .orElse(NONE);
    }

    int getMoney() {
        return money;
    }

    int getMatchedCount() {
        return matchedCount;
    }
}
