package domain.lotto;

import java.util.Arrays;
import java.util.function.Predicate;

public enum LottoPrize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final long countOfMatch;
    private final long winningMoney;

    LottoPrize(long countOfMatch, long winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public long getCountOfMatch() {
        return countOfMatch;
    }

    public long getWinningMoney() {
        return winningMoney;
    }

    public static LottoPrize valueOf(int count, boolean bonusNumber) {
        LottoPrize lottoPrize = matchLottoPrize(count);

        if (isSecondPrize(bonusNumber, lottoPrize)) {
            return LottoPrize.SECOND;
        }

        return lottoPrize;
    }

    private static LottoPrize matchLottoPrize(int count) {
        LottoPrize lottoPrize = Arrays.stream(LottoPrize.values())
                .filter(exceptSecondPrize())
                .filter(match(count))
                .findFirst()
                .orElse(MISS);
        return lottoPrize;
    }

    private static Predicate<LottoPrize> match(int count) {
        return item -> item.countOfMatch == count;
    }

    private static Predicate<LottoPrize> exceptSecondPrize() {
        return item -> item != LottoPrize.SECOND;
    }

    private static boolean isSecondPrize(boolean bonusNumber, LottoPrize lottoPrize) {
        return lottoPrize == FOURTH && bonusNumber;
    }
}
