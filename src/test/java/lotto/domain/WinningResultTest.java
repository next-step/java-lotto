package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningResultTest {

    private WinningResult winningResult;

    @BeforeEach
    public void setUp() {
        winningResult = new WinningResult();
    }

    @DisplayName("당첨3개 5000원")
    @Test
    void 당첨_5000원(){
        //given
        Map<RankLotto, Integer> winCount = Map.of(RankLotto.FOURTH, 3);
        //when
         winningResult.matchCount(winCount);
        Map<RankLotto, Integer> result = winningResult.result();
        //then
        assertThat(result.get(RankLotto.FOURTH)).isEqualTo(RankLotto.FOURTH);
    }
}
