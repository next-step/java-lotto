package lotto.model;

import lotto.model.enums.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingTest {

    @Test
    @DisplayName("2등 당첨자 보너스 당첨일 경우 추출 테스트")
    void when_win_bonus_number(){
        assertThat(Ranking.findRanking(5, true)).isEqualTo(Ranking.BONUS);
    }

    @Test
    @DisplayName("2등 당첨자 보너스 당첨 안했을 경우 추출 테스트")
    void when_no_win_bonus_number(){
        assertThat(Ranking.findRanking(5, false)).isEqualTo(Ranking.SECOND);
    }
}
