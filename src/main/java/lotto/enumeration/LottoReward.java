package lotto.enumeration;

import java.util.Arrays;
import java.util.stream.Stream;

public enum LottoReward {

    NO_MATCHED(0, 0),
    THREE_NUMBERS_MATCHED(3, 5_000),
    FOUR_NUMBERS_MATCHED(4, 50_000),
    FIVE_NUMBERS_MATCHED(5, 1_500_000),
    FIVE_NUMBERS_AND_BONUS_NUMBER_MATCHED(5, 30_000_000),
    SIX_NUMBERS_MATCHED(6, 2_000_000_000);

    final int matchedCount;
    final int rewardMoney;

    LottoReward(int matchedCount, int rewardMoney) {
        this.matchedCount = matchedCount;
        this.rewardMoney = rewardMoney;
    }

    public static LottoReward of(int matchedCount, boolean matchBonusNumber) {

        if (matchedCount == 5 && matchBonusNumber) {
            return FIVE_NUMBERS_AND_BONUS_NUMBER_MATCHED;
        }

        return Arrays.stream(LottoReward.values())
            .filter(o -> o.matchedCount == matchedCount)
            .findFirst()
            .orElse(NO_MATCHED);
    }

    public static Stream<LottoReward> stream() {
        return Stream.of(LottoReward.values());
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public int getMatchedCount() {
        return matchedCount;
    }
}
