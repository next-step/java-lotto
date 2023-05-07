package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningCount {
    SIX(6, false),
    FIVE_WITH_BONUS_BALL(5, true),
    FIVE(5, false),
    FOUR(4, false),
    THREE(3, false);

    private final int count;
    private final boolean isMatchBonusBall;

    private static final List<WinningCount> winningCountList = Stream.of(values()).collect(Collectors.toList());

    WinningCount(int count, boolean isMatchBonusBall) {
        this.count = count;
        this.isMatchBonusBall = isMatchBonusBall;
    }

    public int count() {
        return count;
    }

    public boolean isMatchBonusBall() {
        return isMatchBonusBall;
    }

    public static WinningCount of(int count) {
        return of(count, false);
    }

    public static WinningCount of(int count, boolean isMatchBonusBall) {
        return winningCountList.stream().filter(winningCount -> winningCount.equals(count, isMatchBonusBall)).findAny().get();
    }

    public boolean equals(int count, boolean isMatchBonusBall) {
        return this.count == count && this.isMatchBonusBall == isMatchBonusBall;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(count + "개 일치");
        if (isMatchBonusBall) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        return stringBuilder.toString();
    }
}
