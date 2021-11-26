package lotto.step3.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RankTest {

    @Test
    void first_rank() {
        assertThat(Rank.rank(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.rank(6, true)).isEqualTo(Rank.FIRST);
    }

    @Test
    void second_rank() {
        assertThat(Rank.rank(5, false)).isNotEqualTo(Rank.SECOND);
        assertThat(Rank.rank(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    void third_rank() {
        assertThat(Rank.rank(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.rank(5, true)).isNotEqualTo(Rank.THIRD);
    }

    @Test
    void fourth_rank() {
        assertThat(Rank.rank(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.rank(4, true)).isEqualTo(Rank.FOURTH);
    }

    @Test
    void fifth_rank() {
        assertThat(Rank.rank(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.rank(3, true)).isEqualTo(Rank.FIFTH);
    }

    @Test
    void miss_rank() {
        assertThat(Rank.rank(2, false)).isEqualTo(Rank.MISS);
        assertThat(Rank.rank(2, true)).isEqualTo(Rank.MISS);
    }

    @Test
    void error() {
        assertThatThrownBy(() -> Rank.rank(7, false))
                .isInstanceOf(IllegalArgumentException.class);
    }



}