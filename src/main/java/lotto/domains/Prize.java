package lotto.domains;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2000000000L), SECOND(5, 1500000L), THIRD(4, 50000L), FOURTH(3, 5000L), NONE(2, 0L);

    private final int correctCount;
    private final long reward;

    Prize(int correctCount, long reward) {
        this.correctCount = correctCount;
        this.reward = reward;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public long getReward() {
        return reward;
    }

    public static Prize find(long count) {
        if (count <= NONE.correctCount) {
            return NONE;
        }

        return Arrays.stream(values())
                .filter(p -> p.correctCount == count)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
