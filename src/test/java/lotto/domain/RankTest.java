package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @CsvSource({"6, FALSE, FIRST", "5, TRUE, SECOND", "5, FALSE, THIRD", "4, FALSE, FOURTH", "3, FALSE, FIFTH"})
    @DisplayName("맞춘 번호에 따라 Rank를 반환한다.")
    void match_count_return_rank(int count, boolean isMatchBonus, Rank rank) {
        assertThat(Rank.rankByCount(count, isMatchBonus)).isEqualTo(rank);
    }
}
