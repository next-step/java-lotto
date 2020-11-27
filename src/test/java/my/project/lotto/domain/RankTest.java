package my.project.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created : 2020-11-27 오후 5:11
 * Developer : Seo
 */
class RankTest {
    @Test
    void rank_1st() {
        assertThat(Rank.rank(6, true)).isEqualTo(Rank.FIRST);
        assertThat(Rank.rank(6, false)).isEqualTo(Rank.FIRST);
    }

    @Test
    void rank_2nd() {
        assertThat(Rank.rank(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    void rank_3rd() {
        assertThat(Rank.rank(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    void rank_4th() {
        assertThat(Rank.rank(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.rank(4, true)).isEqualTo(Rank.FOURTH);
    }

    @Test
    void rank_5th() {
        assertThat(Rank.rank(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.rank(3, true)).isEqualTo(Rank.FIFTH);
    }

    @Test
    void no_rank() {
        assertThat(Rank.rank(2, false)).isEqualTo(Rank.NO_RANK);
        assertThat(Rank.rank(2, true)).isEqualTo(Rank.NO_RANK);
    }

    @Test
    void invalid() {
        assertThatThrownBy(() -> Rank.rank(7, false))
                .hasMessage("")
                .isInstanceOf(IllegalArgumentException.class);
    }

}