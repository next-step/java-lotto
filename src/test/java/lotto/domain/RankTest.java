package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class RankTest {

    @DisplayName("로또 맞춘 갯수에 따라 등수 찾기")
    @Test
    void findRank() {
        assertThat(Rank.findRank(3)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.findRank(4)).isEqualTo(Rank.THIRD);
        assertThat(Rank.findRank(5)).isEqualTo(Rank.SECOND);
        assertThat(Rank.findRank(6)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("등수에 없는 갯수는 exception 발생")
    @Test
    void findRank_error() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Rank.findRank(1));
    }
}