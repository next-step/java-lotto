package lotto.lotto;

import java.util.Arrays;

public enum LottoReward {
    NO(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final Integer matchCount;
    private final Integer rewardMoney;

    LottoReward(final Integer matchCount, final Integer rewardMoney) {
        this.matchCount = matchCount;
        this.rewardMoney = rewardMoney;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getRewardMoney() {
        return rewardMoney;
    }

    public static LottoReward valueOfMatchCount(final Integer matchCount) {
        return Arrays.stream(LottoReward.values())
                .filter(value -> value.matchCount.equals(matchCount))
                .findAny()
                .orElse(NO);
    }
}
