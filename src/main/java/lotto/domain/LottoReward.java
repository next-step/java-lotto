package lotto.domain;

import java.util.Arrays;

public enum LottoReward {
    first(6, 2000000000),
    second(5, 1500000),
    third(4, 50000),
    fourth(3, 5000),
    NONE(0,0);

    private final int matchCount;
    private final int prize;

    LottoReward(final int matchCount, final int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoReward calculatePrize(final int matchCount) {
        return Arrays.stream(LottoReward.values())
                .filter(reward -> reward.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
