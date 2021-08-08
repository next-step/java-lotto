package lotto.enumeration;

import java.util.Arrays;

public enum LottoReward {

    NO_REWARD(0, 0),
    THREE_NUMBERS_MATCHED_REWARD(3, 5000),
    FOUR_NUMBERS_MATCHED_REWARD(4, 50000),
    FIVE_NUMBERS_MATCHED_REWARD(5, 1500000),
    SIX_NUMBERS_MATCHED_REWARD(6, 2000000000);

    final int matchedCount;
    final int rewardMoney;

    LottoReward(int matchedCount, int rewardMoney) {
        this.matchedCount = matchedCount;
        this.rewardMoney = rewardMoney;
    }

    public static LottoReward of(int matchedCount) {
        return Arrays.stream(LottoReward.values())
            .filter(o -> o.matchedCount == matchedCount)
            .findFirst()
            .orElse(NO_REWARD);
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public int getMatchedCount() {
        return matchedCount;
    }
}
