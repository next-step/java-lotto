package step3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningStatistics {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private int matchedNumberCount;
    private int winningMoney;

    WinningStatistics(int matchedNumberCount, int winningMoney) {
        this.matchedNumberCount = matchedNumberCount;
        this.winningMoney = winningMoney;
    }

    public static WinningStatistics valueOfWinningCount(int winningCount, boolean hasBonus) {
        if (winningCount == THIRD.matchedNumberCount && hasBonus) {
            return SECOND;
        }

        return Optional.of(Arrays.stream(values())
                    .filter(winningStatistics -> winningStatistics.matchedNumberCount == winningCount)
                    .findAny()
                    .orElse(MISS)
                ).orElse(MISS);
    }

    public static boolean checkMatchedCount(int count) {
        return Arrays.stream(values()).anyMatch(winningStatistics -> winningStatistics.matchedNumberCount == count);
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
