package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @CsvSource({"6,FIRST", "5,SECOND", "4,THIRD", "3,FOURTH"})
    @DisplayName("맞춘 번호에 따라 Rank를 반환한다.")
    void match_count_return_rank(int count, Rank rank) {
        assertThat(Rank.rankByCount(count)).isEqualTo(rank);
    }
}
