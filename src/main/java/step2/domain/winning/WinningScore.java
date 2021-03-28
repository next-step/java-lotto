package step2.domain.winning;

import java.util.Arrays;

public enum WinningScore {

    MISS(0, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 1_500_000);

    private final int correctCount;
    private final long winningAmount;

    WinningScore(int correctCount, long winningAmount ) {
        this.correctCount = correctCount;
        this.winningAmount = winningAmount;
    }

    public static void valueOf(int realCorrectCount) {
        WinningScore winningScore = Arrays.stream(WinningScore.values())
                .filter(operation -> operation.correctCount == realCorrectCount)
                .findFirst().orElse(WinningScore.MISS);
    }

    public final int getCorrectCount() {
        return correctCount;
    }

    public final long getWinningAmount() {
        return winningAmount;
    }

    @Override
    public String toString() {
        return "WinningScore{" +
                "correctCount=" + correctCount +
                ", winningAmount=" + winningAmount +
                '}';
    }
}
