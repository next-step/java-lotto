package lotto.vo;

import java.util.Arrays;

public enum Rank {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    FOURTH_PLACE(3, 5_000),
    FAILURE(0, 0);

    int numberOfMatches, reward;

    Rank(int numberOfMatches, int reward) {
        this.numberOfMatches = numberOfMatches;
        this.reward = reward;
    }

    static Rank valueOf(int matchCount) {
        if (matchCount < 3) {
            return FAILURE;
        }
        return Arrays.stream(values())
                .filter(v -> matchCount == v.numberOfMatches)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("error"));
    }
}
