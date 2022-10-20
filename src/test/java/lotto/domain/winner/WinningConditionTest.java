package lotto.domain.winner;

import static lotto.domain.winner.WinningCondition.MATCH_BONUS;
import static lotto.domain.winner.WinningCondition.MATCH_FIVE;
import static lotto.domain.winner.WinningCondition.MATCH_FOR;
import static lotto.domain.winner.WinningCondition.MATCH_SIX;
import static lotto.domain.winner.WinningCondition.MATCH_THREE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.exception.UnknownWinningConditionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningConditionTest {

    @ParameterizedTest
    @MethodSource("getWinningConditionByMatchCount")
    @DisplayName("주어진 일치 횟수로 해당 당첨 조건 구하기")
    void get_winning_condition_by_match_count(int matchCount, boolean bonusMatch,
            WinningCondition expected) {
        assertThat(WinningCondition.getConditionByMatchCount(matchCount, bonusMatch))
                .isEqualTo(expected);
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
        long countOfPrizeCondition = prizeConditions.stream()
                .filter(condition -> condition.getPrizeMoney() > 0)
                .count();

        assertAll(
                () -> assertThat(prizeConditions)
                        .contains(MATCH_THREE, MATCH_FOR, MATCH_FIVE, MATCH_BONUS, MATCH_SIX),
                () -> assertThat(countOfPrizeCondition).isEqualTo(5)
        );
    }

    public static Stream<Arguments> getWinningConditionByMatchCount() {
        return Stream.of(
                Arguments.arguments(3, false, MATCH_THREE),
                Arguments.arguments(3, true, MATCH_THREE),
                Arguments.arguments(4, false, MATCH_FOR),
                Arguments.arguments(4, true, MATCH_FOR),
                Arguments.arguments(5, false, MATCH_FIVE),
                Arguments.arguments(5, true, MATCH_BONUS),
                Arguments.arguments(6, false, MATCH_SIX),
                Arguments.arguments(6, true, MATCH_SIX)
        );
    }
}