package lotto.domain.winning;

import lotto.domain.exception.InvalidWinningCountException;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public enum WinningReward {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private static final int MIN_WINNING_COUNT = 3;
    private static final int MAX_WINNING_COUNT = 6;

    private final int count;
    private final int winningPrice;

    WinningReward(int count, int winningPrice) {
        this.count = count;
        this.winningPrice = winningPrice;
    }

    public static Stream<Integer> winningCountStream() {
        return Arrays.stream(values()).map(winningReward -> winningReward.count);
    }

    public int getCount() {
        return count;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public static Integer getWinningPrice(int winningCount) {
        return findWinningCount(winningCount)
                .map(rule -> rule.winningPrice)
                .orElseThrow(InvalidWinningCountException::new);
    }

    private static Optional<WinningReward> findWinningCount(int winningCount) {
        return Arrays.stream(values())
                .filter(winningReward -> winningReward.count == winningCount)
                .findFirst();
    }

    public static boolean hasWinningPrice(int winningCount) {
        return winningCount >= MIN_WINNING_COUNT && winningCount <= MAX_WINNING_COUNT;
    }
}
