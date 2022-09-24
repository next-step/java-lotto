package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultMapTest {
    
    @Test
    @DisplayName("총 당첨금 확인")
    void totalReward() {
        ResultMap resultMap = new ResultMap();
        List<MatchNumber> matchNumbers = Arrays.asList(MatchNumber.THREE, MatchNumber.THREE, MatchNumber.SIX);
        assertThat(resultMap.totalReward(matchNumbers)).isEqualTo(2000010000);
    }
}