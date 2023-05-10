package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("[요구사항 1] 로또 번호가 3개 일치하는 경우 4등이다.")
    void 요구사항_1() {
        // given
        int winningCount = 3;

        // then
        assertThat(Rank.findRank(winningCount)).isEqualTo(Rank.FOURTH_PLACE);
    }

    @Test
    @DisplayName("[요구사항 2] 로또 번호가 2개 일치하는 경우 LOST, 즉 꽝이다.")
    void 요구사항_2() {
        // given
        int winningCount = 2;

        // then
        assertThat(Rank.findRank(winningCount)).isEqualTo(Rank.LOST);
    }
}
