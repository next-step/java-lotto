package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.model.Reward.getReward;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;


public class RewardTest {

    @Test
    @DisplayName("로또번호와 똑같은 숫자에 따른 상금이 같은지 비교한다.")
    void getRewardTest() {
        WinningState secondPrize = new WinningState(5, true);
        WinningState thirdPrize = new WinningState(5, false);
        Reward secondReward = getReward(secondPrize);
        Reward thirdReward = getReward(thirdPrize);

        assertAll(
                () -> assertThat(thirdReward.getPrizeMoney()).isEqualTo(1_500_000),
                () -> assertThat(secondReward.getPrizeMoney()).isEqualTo(30_000_000)
        );


    }

}
