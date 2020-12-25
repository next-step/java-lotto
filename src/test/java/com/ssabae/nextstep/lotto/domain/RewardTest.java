package com.ssabae.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest(name = "{displayName}[{index}] - \"{arguments}\"")
    @DisplayName("로또 당첨갯수화 보너스번호 매칭으로 등수 구하기 Test")
    @CsvSource(value = {
            "6,true,FIRST", "6,false,FIRST",
            "5,true,SECOND", "5,false,THIRD",
            "4,true,FOURTH", "4,false,FOURTH",
            "3,true,FIFTH",  "3,false,FIFTH",
            "2,true,NONE",   "2,false,NONE",
            "1,true,NONE",   "1,false,NONE",
            "0,true,NONE",   "0,false,NONE"
    })
    void matchingToRewardTest(int matchCount, boolean matchBonus, Reward reward) {
        assertThat(Reward.matchingToReward(matchCount, matchBonus )).isEqualTo(reward);
    }
}
