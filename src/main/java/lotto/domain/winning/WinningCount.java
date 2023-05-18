package lotto.domain.winning;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningCount {
    SIX(6, false),
    FIVE_WITH_BONUS_BALL(5, true),
    FIVE(5, false),
    FOUR(4, false),
    THREE(3, false),
    NONE(0, false);

    private static final List<WinningCount> winningCountList = Stream.of(values()).collect(Collectors.toList());

    private final int count;
    private final boolean isMatchBonusNo;

    WinningCount(int count, boolean isMatchBonusBall) {
        this.count = count;
        this.isMatchBonusNo = isMatchBonusBall;
    }

    public static WinningCount of(int count, boolean isMatchBonusBall) {
        return winningCountList.stream().filter(winningCount -> winningCount.equals(count, isMatchBonusBall)).findAny().orElse(WinningCount.NONE);
    }

    public static boolean isRewardWinningCount(WinningCount winningCount) {
        return winningCount != WinningCount.NONE;
    }

    public boolean equals(int count, boolean isMatchBonusNo) {
        return this.count == count && this.isMatchBonusNo == isMatchBonusNo;
    }

    public int getCount() {
        return count;
    }
    public boolean getIsMatchBonusNo() {
        return isMatchBonusNo;
    }
}
