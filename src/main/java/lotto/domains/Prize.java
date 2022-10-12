package lotto.domains;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2000000000L), SECOND(5, 1500000L), THIRD(4, 50000L), FOURTH(3, 5000L), NONE(0, 0L);

    private final int correctCount;
    private final long reward;

    Prize(int correctCount, long reward) {
        this.correctCount = correctCount;
        this.reward = reward;
    }

    public static Prize find(long count) {
        if (count <= 2) {
            return NONE;
        }

        return Arrays.stream(values())
                .filter(p -> p.correctCount == count)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
