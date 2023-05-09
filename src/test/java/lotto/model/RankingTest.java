package lotto.model;

import lotto.model.enums.MatchingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingTest {

    @Test
    @DisplayName("2등 당첨자 보너스 당첨일 경우 추출 테스트")
    void when_win_bonus_number(){
        assertThat(MatchingStrategy.find(5, true)).isEqualTo(MatchingStrategy.FIVE_WITH_BONUS);
    }

    @Test
    @DisplayName("2등 당첨자 보너스 당첨 안했을 경우 추출 테스트")
    void when_no_win_bonus_number(){
        assertThat(MatchingStrategy.find(5, false)).isEqualTo(MatchingStrategy.FIVE);
    }

    @Test
    @DisplayName("당첨자 추출 테스트")
    void check_get_winner(){
        assertThat(MatchingStrategy.find(3, false)).isEqualTo(MatchingStrategy.THREE);
        assertThat(MatchingStrategy.find(4, false)).isEqualTo(MatchingStrategy.FOUR);
        assertThat(MatchingStrategy.find(5, false)).isEqualTo(MatchingStrategy.FIVE);
        assertThat(MatchingStrategy.find(6, false)).isEqualTo(MatchingStrategy.SIX);
    }
}
