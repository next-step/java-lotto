package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TotalRewardCalculateMapTest {
    
    @Test
    @DisplayName("총 당첨금 확인")
    void totalReward() {
        TotalRewardCalculateMap totalRewardCalculateMap = new TotalRewardCalculateMap();
        List<MatchNumber> matchNumbers = Arrays.asList(MatchNumber.THREE, MatchNumber.THREE, MatchNumber.SIX);
        assertThat(totalRewardCalculateMap.totalReward(matchNumbers)).isEqualTo(2000010000);
    }
}