package lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    NO_MATCH(0, 0),
    FOURTH_PRIZE(3, 5000),
    THIRD_PRIZE(4, 50000),
    SECOND_PRIZE(5, 1500000),
    FIRST_PRIZE(6, 2000000000);

    private final int reward;
    private final int match;

    LottoResult(int match, int reward) {
        this.match = match;
        this.reward = reward;
    }

    public static LottoResult of(int match) {
        return Arrays.stream(values())
                .filter(value -> match == value.match)
                .findFirst()
                .orElse(NO_MATCH);
    }

    public int getReward() {
        return this.reward;
    }
}
