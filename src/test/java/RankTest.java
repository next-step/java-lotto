import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RankTest {

    @DisplayName("일치 개수와 보너스 번호 여부에 따라 등수를 정확히 계산한다")
    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "2, false, MISS"
    })
    void should_determine_rank_based_on_match_count_and_bonus_number(int countOfMatch, boolean matchBonus, Rank expected) {
        Rank rank = Rank.fromMatchCountAndBonus(countOfMatch, matchBonus);
        assertThat(rank).isEqualTo(expected);
    }

    @DisplayName("7개 이상의 일치 개수를 입력하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {7, 10, 100})
    void should_throw_exception_when_match_count_exceeds_six(int countOfMatch) {
        assertThatThrownBy(() -> Rank.fromMatchCountAndBonus(countOfMatch, false))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("일치하는 번호는 최대 6개까지만 가능합니다.");
    }

    @DisplayName("각 등수별 상금이 올바르게 설정되어 있다")
    @ParameterizedTest
    @CsvSource({
            "FIRST, 2000000000",
            "SECOND, 30000000",
            "THIRD, 1500000",
            "FOURTH, 50000",
            "FIFTH, 5000",
            "MISS, 0"
    })
    void should_have_correct_winning_money_for_each_rank(String rankName, int expectedWinningMoney) {
        Rank rank = Rank.valueOf(rankName);
        assertThat(rank.getWinningMoney()).isEqualTo(expectedWinningMoney);
    }
}
