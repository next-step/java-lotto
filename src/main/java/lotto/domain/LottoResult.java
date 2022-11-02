package lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    NO_MATCH(0, 0),
    FIFTH_PRIZE(3, 5000),
    FOURTH_PRIZE(4, 50000),
    THIRD_PRIZE(5, 1500000),
    SECOND_PRIZE(5, 30000000),
    FIRST_PRIZE(6, 2000000000);

    private final int reward;
    private final int match;

    LottoResult(int match, int reward) {
        this.match = match;
        this.reward = reward;
    }

    public static LottoResult of(int match, boolean matchBonus) {
        LottoResult result = Arrays.stream(values())
                .filter(value -> match == value.match)
                .findFirst()
                .map(value -> value.equals(THIRD_PRIZE) && matchBonus ? SECOND_PRIZE : value)
                .orElse(NO_MATCH);
        return result;
    }

    public int getReward() {
        return this.reward;
    }
}
