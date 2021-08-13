package domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoPrizeType {
    FOURTH_PRIZE(3, 5000),
    THIRD_PRIZE(4, 50000),
    SECOND_PRIZE(5, 1500000),
    FIRST_PRIZE(6, 2000000000);

    private int matchCount;

    private int winningAmount;

    LottoPrizeType(int matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public static LottoPrizeType findLottoPrizeByMatchCount(int matchCount) {
        Optional<LottoPrizeType> lottoPrizeType = Arrays.stream(LottoPrizeType.values()).filter(type -> type.matchCount == matchCount).findFirst();
        return lottoPrizeType.orElse(null);
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getWinningAmount() {
        return this.winningAmount;
    }

}
