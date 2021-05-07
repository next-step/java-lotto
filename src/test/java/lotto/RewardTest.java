package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static lotto.Reward.getReward;
import static org.assertj.core.api.Assertions.*;


public class RewardTest {

    @Test
    @DisplayName("로또번호와 똑같은 숫자에 따른 상금이 같은지 비교한다.")
    void getRewardTest() {
        List matchCounts = new ArrayList();
        List matchCounts2 = new ArrayList();
        matchCounts.add("5");
        matchCounts.add("1");
        matchCounts2.add("4");
        matchCounts2.add("0");
        Reward reward = getReward(matchCounts);
        Reward reward2 = getReward(matchCounts2);

        assertThat(reward.getPrizeMoney()).isEqualTo(30000000);
        assertThat(reward2.getPrizeMoney()).isEqualTo(50000);
    }
}
