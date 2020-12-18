package com.ssabae.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
}
