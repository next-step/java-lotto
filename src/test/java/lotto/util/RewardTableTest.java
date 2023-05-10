package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RewardTableTest {

    @DisplayName("로또 게임 맞춘 갯수와 보너스를 전달하면 등수를 응답한다.")
    @ParameterizedTest
    @CsvSource(value = {"3:FIFTH_RANK:false", "4:FOURTH_RANK:false","5:THIRD_RANK:false", "5:SECOND_RANK:true", "6:FIRST_RANK:false"}, delimiterString = ":")
    public void rewardTableTest_등수_확인_테스트(int matchRank, RewardTable rewardTableEnum, Boolean isBonus) {

        assertThat(RewardTable.of(matchRank, isBonus)).isEqualTo(rewardTableEnum);
    }

    @DisplayName("로또 게임 맞춘 갯수가 등수에 없다면 에러를 응답한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void rewardTableTest_없는_등수_테스트(int matchRank) {
        assertThatThrownBy(() -> RewardTable.of(matchRank, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 게임 맞춘 갯수와 게임 수를 전달하면 당첨 금액을 응답한다.")
    @ParameterizedTest
    @CsvSource(value = {"3:5:25000:false", "4:2:100000:false", "5:1:1500000:false", "5:1:30000000:true", "6:1:2000000000:false"}, delimiterString = ":")
    public void rewardTableTest_당첨금액_확인_테스트(int matchRank, Long matchGameNum, int rewardNum, Boolean isBonus) {
        assertThat(RewardTable.of(matchRank, isBonus).matchReward(matchGameNum)).isEqualTo(rewardNum);
    }
}
