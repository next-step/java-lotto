package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {

    FIFTH(WinningCount.THREE, 5_000),
    FOURTH(WinningCount.FOUR, 50_000),
    THIRD(WinningCount.FIVE, 1_500_000),
    SECOND(WinningCount.FIVE_WITH_BONUS_BALL, 3_000_000),
    FIRST(WinningCount.SIX, 2_000_000_000);

    private WinningCount winningCount;
    private final int reward;

    private static final Map<WinningCount, Integer> rank = Stream.of(values()).collect(Collectors.toMap(Rank::winningCount, Rank::reward));

    Rank(WinningCount winningCount, int reward) {
        this.winningCount = winningCount;
        this.reward = reward;
    }

    public WinningCount winningCount() {
        return winningCount;
    }

    public int reward() {
        return reward;
    }

    public static int of(WinningCount winningCount) {
        return rank.get(winningCount);
    }

    public static List<WinningCount> getWinningCounts() {
        return Stream.of(values()).map(Rank::winningCount).collect(Collectors.toList());
    }
}
