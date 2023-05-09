package lotto.domian;

import lotto.domain.Reward;
import lotto.util.RewardTable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardTest {

    @DisplayName("로또 게임 맞춘 전체 금액을 응답한다.")
    @Test
    public void rewardTest_게임_정답_전체금액_테스트() {
        Map<RewardTable, Integer> resultGameMap = new HashMap<>();
        resultGameMap.put(RewardTable.of(3, null), 2);    //  10_000
        resultGameMap.put(RewardTable.of(4, null), 2);    //  100_000
        resultGameMap.put(RewardTable.of(5, false), 1);   //  1_500_000
        resultGameMap.put(RewardTable.of(6, null), 1);    //  2_000_000_000

        assertThat(new Reward().sumTotalMatchPrice(resultGameMap)).isEqualTo(2_001_610_000);
    }
}
