package lotto.enumeration;

import java.util.Arrays;
import java.util.stream.Stream;

public enum LottoReward {

    NO_MATCHED(0, false, 0),
    THREE_NUMBERS_MATCHED(3, false, 5_000),
    FOUR_NUMBERS_MATCHED(4, false, 50_000),
    FIVE_NUMBERS_MATCHED(5, false, 1_500_000),
    FIVE_NUMBERS_AND_BONUS_NUMBER_MATCHED(5, true, 30_000_000),
    SIX_NUMBERS_MATCHED(6, false, 2_000_000_000);

    final int matchedNumberCount;
    final boolean hasMatchedBonusNumber;
    final int rewardMoney;

    LottoReward(int matchedNumberCount, boolean hasMatchedBonusNumber, int rewardMoney) {
        this.matchedNumberCount = matchedNumberCount;
        this.hasMatchedBonusNumber = hasMatchedBonusNumber;
        this.rewardMoney = rewardMoney;
    }

    public static LottoReward of(int matchedNumberCount, boolean hasMatchedBonusNumber) {

        return Arrays.stream(LottoReward.values())
            .filter(o -> o.matchedNumberCount == matchedNumberCount)
            .filter(o -> o.hasMatchedBonusNumber == hasMatchedBonusNumber)
            .findFirst()
            .orElse(NO_MATCHED);
    }

    public static Stream<LottoReward> stream() {
        return Stream.of(LottoReward.values());
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public boolean hasMatchedBonusNumber() {
        return hasMatchedBonusNumber;
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }
}
