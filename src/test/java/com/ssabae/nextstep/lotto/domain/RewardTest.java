package com.ssabae.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
@DisplayName("로또 당첨 금액 Test Class")
class RewardTest {

    @Test
    @DisplayName("로또 1등 당첨 금액 Test")
    void rewardTest() {
        Money money = Reward.getWinningMoneyByMatchCount(6);
        assertThat(money).isEqualTo(Reward.FIRST.getWinningMoney());
    }

    @ParameterizedTest(name = "{displayName}[{index}] - \"{arguments}\"")
    @DisplayName("로또 당첨 금액 0원 Test")
    @ValueSource(ints = {0, 1, 2})
    void rewardZeroWonTest(int value) {
        Money money = Reward.getWinningMoneyByMatchCount(value);
        assertThat(money).isEqualTo(Money.won(0L));
    }

    @Test
    @DisplayName("로또 당첨갯수화 보너스번호 매칭으로 등수 구하기 Test")
    void matchingToRewardTest() {
        assertAll(
            () -> assertThat(Reward.matchingToReward(6, true )).isEqualTo(Reward.FIRST),
            () -> assertThat(Reward.matchingToReward(6, false)).isEqualTo(Reward.FIRST),

            () -> assertThat(Reward.matchingToReward(5, true )).isEqualTo(Reward.SECOND),
            () -> assertThat(Reward.matchingToReward(5, false)).isEqualTo(Reward.THIRD),

            () -> assertThat(Reward.matchingToReward(4, false)).isEqualTo(Reward.FOURTH),
            () -> assertThat(Reward.matchingToReward(4, true )).isEqualTo(Reward.FOURTH),

            () -> assertThat(Reward.matchingToReward(3, false)).isEqualTo(Reward.FIFTH),
            () -> assertThat(Reward.matchingToReward(3, true )).isEqualTo(Reward.FIFTH),

            () -> assertThat(Reward.matchingToReward(2, false)).isEqualTo(Reward.NONE),
            () -> assertThat(Reward.matchingToReward(2, true )).isEqualTo(Reward.NONE),

            () -> assertThat(Reward.matchingToReward(1, false)).isEqualTo(Reward.NONE),
            () -> assertThat(Reward.matchingToReward(1, true )).isEqualTo(Reward.NONE),

            () -> assertThat(Reward.matchingToReward(0, false)).isEqualTo(Reward.NONE),
            () -> assertThat(Reward.matchingToReward(0, true )).isEqualTo(Reward.NONE)
        );
    }
}
