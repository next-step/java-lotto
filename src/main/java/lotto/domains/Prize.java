package lotto.domains;

import java.util.Arrays;

public enum Prize {
    NONE(2, 0L, false, false),
    FIFTH(3, 5_000L, true, false),
    FOURTH(4, 50_000L, true, false),
    THIRD(5, 1_500_000L, true, false),
    SECOND(5, 300_000_000L, true, true),
    FIRST(6, 2_000_000_000L, true, false);

    private final int correctCount;
    private final long reward;
    private final boolean isWinner;
    private final boolean bonus;

    Prize(int correctCount, long reward, boolean isWinner, boolean bonus) {
        this.correctCount = correctCount;
        this.reward = reward;
        this.isWinner = isWinner;
        this.bonus = bonus;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public long getReward() {
        return reward;
    }

    public static Prize find(long count, boolean bonus) {
        if (count == SECOND.correctCount && bonus) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(p -> p.correctCount == count && !p.bonus)
                .findFirst()
                .orElse(Prize.NONE);
    }

    public boolean isWin() {
        return isWinner;
    }
}
