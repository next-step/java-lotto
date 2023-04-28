package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRewardsTest {

    LottoRewards lottoRewards;

    @BeforeEach
    void setUp() {
        lottoRewards = new LottoRewards();
    }

    @Test
    void 원소_추가() {
        //given
        //when
        lottoRewards.add(new LottoReward(RewardType.THREE, 1));

        //then
        assertThat(lottoRewards.get(RewardType.THREE).count()).isEqualTo(1);
    }

    @Test
    void count_증가() {
        //given
        lottoRewards.add(new LottoReward(RewardType.THREE, 1));

        //when
        lottoRewards.increaseCountOf(RewardType.THREE);

        //then
        assertThat(lottoRewards.get(RewardType.THREE).count()).isEqualTo(2);
    }

    @Test
    void rewardType_비교() {
        //given
        lottoRewards.add(new LottoReward(RewardType.THREE, 1));

        //when
        //then
        assertThat(lottoRewards.isNotContainRewardType(RewardType.THREE)).isFalse();
    }
}