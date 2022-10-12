package lotto.domains;

import java.util.Arrays;

public enum Prize {
    FIRST(6), SECOND(5), THIRD(4), FOURTH(3), NONE(0);

    private final int correctCount;

    Prize(int correctCount) {
        this.correctCount = correctCount;
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
