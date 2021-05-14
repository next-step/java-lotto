package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.Reward.getReward;
import static org.assertj.core.api.Assertions.*;


public class RewardTest {

    @Test
    @DisplayName("로또번호와 똑같은 숫자에 따른 상금이 같은지 비교한다.")
    void getRewardTest() {
       WinningLotto secondPrize = new WinningLotto(5, true);
        WinningLotto fourthPrize = new WinningLotto(4,false);
        Reward secondReward = getReward(secondPrize);
        Reward fourthReward = getReward(fourthPrize);

        assertThat(secondReward.getPrizeMoney()).isEqualTo(30000000);
        assertThat(fourthReward.getPrizeMoney()).isEqualTo(50000);
    }

}
