package lotto.domain;

import lotto.common.type.WinnerRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardStatisticsTest {

    private RewardStatistics rewardStatistics;

    @BeforeEach
    void resetRewardStatistics(){
        rewardStatistics = new RewardStatistics();
    }

    @Test
    @DisplayName("카운트 더했을 때 수익금 확인")
    void testIfGetValidProfit(){
        rewardStatistics.plusCount(WinnerRank.FIRST);
        rewardStatistics.plusCount(WinnerRank.SECOND);

        assertThat(rewardStatistics.getAllProfit()).isEqualTo(WinnerRank.FIRST.getReward() + WinnerRank.SECOND.getReward());
    }

    @Test
    @DisplayName("카운트 더했을 때 수익률 확인")
    void testIfGetValidProfitRatio(){
        rewardStatistics.plusCount(WinnerRank.FIFTH);
        rewardStatistics.plusCount(WinnerRank.FIFTH);

        Lotto lotto1 = Lotto.from("1,2,3,4,5,6");
        Lotto lotto2 = Lotto.from("1,2,3,4,5,6");
        Lotto lotto3 = Lotto.from("1,2,3,4,5,6");
        Lotto lotto4 = Lotto.from("1,2,3,4,5,6");
        Lotto lotto5 = Lotto.from("1,2,3,4,5,6");

        Lottos lottos = new Lottos(Arrays.asList(lotto1,lotto2,lotto3,lotto4,lotto5));

        assertThat(rewardStatistics.getProfitRatio(lottos)).isEqualTo(2.0);
    }
}
