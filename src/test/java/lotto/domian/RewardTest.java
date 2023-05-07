package lotto.domian;

import lotto.domain.Reward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardTest {

    @DisplayName("로또 게임 맞춘 전체 금액을 응답한다.")
    @Test
    public void rewardTest_게임_정답_전체금액_테스트() {
        Map<Integer, Integer> resultGameMap = new HashMap<>();
        resultGameMap.put(3, 2);    //  10000
        resultGameMap.put(4, 2);    //  100000
        resultGameMap.put(5, 1);    //  150000
        resultGameMap.put(6, 1);    //  2000000000

        assertThat(new Reward().sumTotalMatchPrice(resultGameMap)).isEqualTo(2000260000);
    }
}
