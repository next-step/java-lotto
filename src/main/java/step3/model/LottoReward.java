package step3.model;

import java.util.Arrays;

public enum LottoReward {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    BANG(0, 0);

    private final int matchCount;
    private final Money reward;

    LottoReward(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = new Money(reward);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getReward() {
        return reward;
    }

    public static LottoReward of(int matchCount, boolean isBonusMatch) {
        LottoReward lottoReward = fromMatchCount(matchCount);
        if (lottoReward.equals(THIRD) && isBonusMatch) {
            return SECOND;
        }
        return lottoReward;
    }

    private static LottoReward fromMatchCount(int matchCount) {
        return Arrays.stream(values())
            .filter(lottoReward -> lottoReward.getMatchCount() == matchCount)
            .findAny()
            .orElse(BANG);
    }
}
