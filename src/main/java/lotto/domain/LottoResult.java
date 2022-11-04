package lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    NO_MATCH(0, 0),
    FIFTH_PRIZE(3, 5000),
    FOURTH_PRIZE(4, 50000),
    THIRD_PRIZE(5, 1500000),
    SECOND_PRIZE(5, 30000000, true),
    FIRST_PRIZE(6, 2000000000);

    private final int reward;
    private final int match;
    private final boolean hasBonus;

    LottoResult(int match, int reward, boolean hasBonus) {
        this.match = match;
        this.reward = reward;
        this.hasBonus = hasBonus;
    }

    LottoResult(int match, int reward) {
        this(match, reward, false);
    }

    public static LottoResult of(int match, boolean matchBonus) {
        LottoResult result = Arrays.stream(values())
                .filter(value -> match == value.match)
                .filter(value -> matchBonus == value.hasBonus)
                .findFirst()
                .orElse(NO_MATCH);
        return result;
    }

    public int getReward() {
        return this.reward;
    }
}
