package lotto.enumeration;

import java.util.Arrays;
import java.util.stream.Stream;
import lotto.exception.WrongMatchedCountException;

public enum LottoReward {

    NO_MATCHED(0, 0),
    THREE_NUMBERS_MATCHED(3, 5_000),
    FOUR_NUMBERS_MATCHED(4, 50_000),
    FIVE_NUMBERS_MATCHED(5, 1_500_000),
    FIVE_NUMBERS_AND_BONUS_NUMBER_MATCHED(5, 30_000_000),
    SIX_NUMBERS_MATCHED(6, 2_000_000_000);

    final int matchedNumberCount;
    final int rewardMoney;

    LottoReward(int matchedNumberCount, int rewardMoney) {
        this.matchedNumberCount = matchedNumberCount;
        this.rewardMoney = rewardMoney;
    }

    public static LottoReward of(int matchedNumberCount, boolean hasMatchedBonusNumber) {

        if (THREE_NUMBERS_MATCHED.matchedNumberCount > matchedNumberCount) {
            return NO_MATCHED;
        }

        if (FIVE_NUMBERS_MATCHED.isSameMatchedCount(matchedNumberCount) && hasMatchedBonusNumber) {
            return FIVE_NUMBERS_AND_BONUS_NUMBER_MATCHED;
        }

        return Arrays.stream(LottoReward.values())
            .filter(reward -> reward.isSameMatchedCount(matchedNumberCount))
            .findFirst()
            .orElseThrow(() -> new WrongMatchedCountException(
                String.format("숫자 일치개수가 잘못 입력되었습니다. [입력된 숫자일치 개수: %d]", matchedNumberCount)));
    }


    private boolean isSameMatchedCount(int matchedNumberCount) {
        return this.matchedNumberCount == matchedNumberCount;
    }

    public static Stream<LottoReward> stream() {
        return Stream.of(LottoReward.values());
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

}
