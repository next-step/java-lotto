package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("맞는 숫자의 개수에 따라 등수 반환")
    void returnRankByMatchNumberCount() {
        assertThat(Rank.getRank(6)).isEqualTo(Rank.FIRST);
        assertThat(Rank.getRank(5)).isEqualTo(Rank.SECOND);
        assertThat(Rank.getRank(4)).isEqualTo(Rank.THIRD);
        assertThat(Rank.getRank(3)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.getRank(2)).isEqualTo(Rank.LOSE);
        assertThat(Rank.getRank(1)).isEqualTo(Rank.LOSE);
        assertThat(Rank.getRank(0)).isEqualTo(Rank.LOSE);
    }

}