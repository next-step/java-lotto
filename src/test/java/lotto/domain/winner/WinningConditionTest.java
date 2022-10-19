package lotto.domain.winner;

import static lotto.domain.winner.WinningCondition.MATCH_BONUS;
import static lotto.domain.winner.WinningCondition.MATCH_FIVE;
import static lotto.domain.winner.WinningCondition.MATCH_FOR;
import static lotto.domain.winner.WinningCondition.MATCH_SIX;
import static lotto.domain.winner.WinningCondition.MATCH_THREE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import lotto.domain.exception.UnknownWinningConditionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningConditionTest {

    @Test
    @DisplayName("주어진 일치 횟수로 해당 당첨 조건 구하기")
    void get_winning_condition_by_match_count() {
        assertThat(WinningCondition.getConditionByMatchCount(3, false)).isEqualTo(
                MATCH_THREE);
        assertThat(WinningCondition.getConditionByMatchCount(3, true)).isEqualTo(
                MATCH_THREE);
        assertThat(WinningCondition.getConditionByMatchCount(5, false)).isEqualTo(
                MATCH_FIVE);
        assertThat(WinningCondition.getConditionByMatchCount(5, true)).isEqualTo(
                MATCH_BONUS);
        assertThat(WinningCondition.getConditionByMatchCount(6, false)).isEqualTo(
                MATCH_SIX);
    }

    @Test
    @DisplayName("주어진 일치 횟수에 해당하는 당첨 조건이 없다면 예외 발생")
    void fail_to_get_winning_condition_by_unknown_match_count() {
        assertThatExceptionOfType(UnknownWinningConditionException.class)
                .isThrownBy(() -> WinningCondition.getConditionByMatchCount(100, false));
    }

    @Test
    @DisplayName("당첨금이 주어진 당첨 조건들 구하기")
    void get_conditions_with_prize() {
        List<WinningCondition> prizeConditions = WinningCondition.getConditionsWithPrize();
        
        assertThat(prizeConditions).contains(MATCH_THREE, MATCH_FOR, MATCH_FIVE, MATCH_BONUS, MATCH_SIX);
        assertThat(prizeConditions.stream()
                .filter(condition -> condition.getPrizeMoney() > 0)
                .count()
        ).isEqualTo(5);
    }
}