package domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoPrizeType {
    MISS(0, false, 0, false),
    FIFTH_PRIZE(3, false, 5_000, true),
    FOURTH_PRIZE(4, false, 50_000, true),
    THIRD_PRIZE(5, false, 1_500_000, true),
    SECOND_PRIZE(5, true, 30_000_000, true),
    FIRST_PRIZE(6, false, 2_000_000_000, true);

    private int matchCount;

    private boolean hasBonusNumber;

    private int winningAmount;

    private boolean isExposure;


    LottoPrizeType(int matchCount, boolean hasBonusNumber, int winningAmount, boolean isExposure) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        this.winningAmount = winningAmount;
        this.isExposure = isExposure;
    }

    public static Optional<LottoPrizeType> findLottoPrizeByMatchCount(int matchCount, boolean hasBonusNumber) {
        Optional<LottoPrizeType> lottoPrizeType = Arrays.stream(LottoPrizeType.values())
                .filter(type -> type.matchCount == matchCount)
                .filter(type -> type.hasBonusNumber == hasBonusNumber)
                .findFirst();
        return lottoPrizeType;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getWinningAmount() {
        return this.winningAmount;
    }

    public boolean isExposure() {
        return this.isExposure;
    }

}
