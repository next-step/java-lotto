package lotto.domains;

import java.util.Arrays;

public enum Prize {
    NONE(2, 0L, false),
    FOURTH(3, 5_000L, true),
    THIRD(4, 50_000L, true),
    SECOND(5, 1_500_000L, true),
    FIRST(6, 2_000_000_000L, true);

    private final int correctCount;
    private final long reward;
    private final boolean isWinner;

    Prize(int correctCount, long reward, boolean isWinner) {
        this.correctCount = correctCount;
        this.reward = reward;
        this.isWinner = isWinner;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public long getReward() {
        return reward;
    }

    public static Prize find(long count) {
        return Arrays.stream(values())
                .filter(p -> p.correctCount == count)
                .findFirst()
                .orElse(Prize.NONE);
    }

    public boolean isWin() {
        return isWinner;
    }
}
