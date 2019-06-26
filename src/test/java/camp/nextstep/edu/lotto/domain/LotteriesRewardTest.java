package camp.nextstep.edu.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteriesRewardTest implements LotteriesRewardHelper {

    @Test
    @DisplayName("객체가 잘 생성되어야합니다")
    void defaultInstance1() {
        final LotteriesReward lotteriesReward = LotteriesReward.defaultInstance();
        assertThat(lotteriesReward).isInstanceOf(LotteriesReward.class);
    }

    @Test
    @DisplayName("초기값이 잘 지정되어야합니다")
    void defaultInstance2() {
        final LotteriesReward lotteriesReward = LotteriesReward.defaultInstance();
        assertThat(lotteriesReward.entrySet()).hasSize(4);
    }

    @Test
    @DisplayName("보상 합계가 잘 계산되어야합니다 - 아무것도 당첨되지 않은 경우")
    void sumAllRewards0() {
        // given
        final LotteriesReward lotteriesReward = LotteriesReward.defaultInstance();
        // when
        final long actual = lotteriesReward.sumAllRewards();
        // then
        assertThat(actual).isEqualTo(0);
    }

    @Test
    @DisplayName("보상 합계가 잘 계산되어야합니다 - 1등")
    void sumAllRewards1() {
        this.testSumAllRewards(RewardType.SIX_NUMBERS_MATCHED, 2_000_000_000);
    }

    @Test
    @DisplayName("보상 합계가 잘 계산되어야합니다 - 2등")
    void sumAllRewards2() {
        this.testSumAllRewards(RewardType.FIVE_NUMBERS_MATCHED, 1_500_000);
    }

    @Test
    @DisplayName("보상 합계가 잘 계산되어야합니다 - 3등")
    void sumAllRewards3() {
        this.testSumAllRewards(RewardType.FOUR_NUMBERS_MATCHED, 50_000);
    }

    @Test
    @DisplayName("보상 합계가 잘 계산되어야합니다 - 4등")
    void sumAllRewards4() {
        this.testSumAllRewards(RewardType.THREE_NUMBERS_MATCHED, 5_000);
    }

    private void testSumAllRewards(RewardType rewardType, int expected) {
        // given
        final LotteriesReward lotteriesReward = LotteriesReward.defaultInstance();
        lotteriesReward.add(rewardType);
        // when
        final long actual = lotteriesReward.sumAllRewards();
        // then
        assertThat(actual).isEqualTo(expected);
    }
}