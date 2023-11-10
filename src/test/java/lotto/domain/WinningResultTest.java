package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningResultTest {

    private WinningResult winningResult;

    public void setUp(Map<RankLotto, Integer> result) {
        winningResult = new WinningResult(result);
    }

    @DisplayName("당첨3개 5000원, 3개")
    @Test
    void 당첨_5000원(){
        //given
        setUp(Map.of(RankLotto.FOURTH, 3));
        //when
        Map<RankLotto, Integer> result = winningResult.result();
        //then
        assertThat(result.get(RankLotto.FOURTH)).isEqualTo(3);
    }

    @DisplayName("당첨 총액")
    @Test
    void 당첨_상금총액(){
        //given
        setUp(Map.of(RankLotto.FIRST, 0, RankLotto.SECOND, 0, RankLotto.THIRD, 0, RankLotto.FOURTH, 3, RankLotto.MISS, 0));
        //when
        int result = winningResult.totalPrize();
        //then
        assertThat(result).isEqualTo(RankLotto.FOURTH.winningMoney() * 3);
    }
}
