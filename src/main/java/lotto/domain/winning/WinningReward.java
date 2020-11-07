package lotto.domain.winning;

import java.util.Arrays;
import java.util.stream.Stream;

public enum WinningReward {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_WITH_BONUS(5, 30_000_000, true),
    SIX(6, 2_000_000_000),
    ZERO(0, 0);

    private final int count;
    private final int winningPrice;
    private final boolean matchBonusNumber;

    WinningReward(int count, int winningPrice) {
        this.count = count;
        this.winningPrice = winningPrice;
        this.matchBonusNumber = false;
    }

    WinningReward(int count, int winningPrice, boolean matchBonusNumber) {
        this.count = count;
        this.winningPrice = winningPrice;
        this.matchBonusNumber = matchBonusNumber;
    }

    public static Stream<WinningReward> valuesStreamWithoutZero() {
        return Arrays.stream(values())
                .filter(winningReward -> !winningReward.equals(ZERO));
    }

    public int getCount() {
        return count;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public static WinningReward valueOf(int winningCount, boolean matchBonusNumber) {
        return Arrays.stream(values())
                .filter(winningReward -> winningReward.count == winningCount && winningReward.matchBonusNumber == matchBonusNumber)
                .findFirst()
                .orElse(ZERO);
    }

    public boolean matchBonusNumber() {
        return matchBonusNumber;
    }
}
