package lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    NoMatch(0, 0),
    FourthPrize(3, 5000),
    ThirdPrize(4, 50000),
    SecondPrize(5, 1500000),
    FirstPrize(6, 2000000000);

    private final int reward;
    private final int match;

    LottoResult(int match, int reward) {
        this.match = match;
        this.reward = reward;
    }

    public static LottoResult of(int rank) {
        return Arrays.stream(values())
                .filter(value -> value.isSameAsMatch(rank))
                .findFirst()
                .orElse(NoMatch);
    }

    public int getReward() {
        return this.reward;
    }

    private boolean isSameAsMatch(int match) {
        return this.match == match;
    }
}
