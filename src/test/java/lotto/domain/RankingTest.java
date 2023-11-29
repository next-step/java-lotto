package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTest {

    @Test
    @DisplayName("ranked_non_Ranking.NOT_RANKED 제외한 전체 포함")
    void ranked() {
        assertThat(Ranking.ranked()).containsExactly(Ranking.FIFTH, Ranking.FOURTH, Ranking.THIRD, Ranking.SECOND, Ranking.FIRST);
    }

    @Test
    @DisplayName("of_matchingCount, hasBonusNumber_당첨 등수 반환")
    void of() {
        assertThat(Ranking.of(6, true)).isEqualTo(Ranking.FIRST);
        assertThat(Ranking.of(6, false)).isEqualTo(Ranking.FIRST);
        assertThat(Ranking.of(5, true)).isEqualTo(Ranking.SECOND);
        assertThat(Ranking.of(5, false)).isEqualTo(Ranking.THIRD);
        assertThat(Ranking.of(4, true)).isEqualTo(Ranking.FOURTH);
        assertThat(Ranking.of(4, false)).isEqualTo(Ranking.FOURTH);
        assertThat(Ranking.of(3, true)).isEqualTo(Ranking.FIFTH);
        assertThat(Ranking.of(3, false)).isEqualTo(Ranking.FIFTH);
    }
}