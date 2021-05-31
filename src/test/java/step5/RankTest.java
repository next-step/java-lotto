package step5;

import org.junit.jupiter.api.Test;
import step5.domain.Rank;
import step5.exception.IllegalRankNumberException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RankTest {

    @Test
    void rank_inValid() {
        assertThatThrownBy(() -> {
            Rank.rank(7, false);
        }).isInstanceOf(IllegalRankNumberException.class);
    }


    @Test
    void rank_꽝() {
        assertThat(Rank.rank(2, true)).isEqualTo(Rank.MISS);
        assertThat(Rank.rank(2, false)).isEqualTo(Rank.MISS);
    }

    @Test
    void rank_5등() {
        assertThat(Rank.rank(3, true)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.rank(3, false)).isEqualTo(Rank.FIFTH);
    }

    @Test
    void rank_4등() {
        assertThat(Rank.rank(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.rank(4, false)).isEqualTo(Rank.FOURTH);
    }

    @Test
    void rank_3등() {
        assertThat(Rank.rank(5, false)).isEqualTo(Rank.THIRD
        );
    }

    @Test
    void rank_2등() {
        assertThat(Rank.rank(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    void rank_1등() {
        assertThat(Rank.rank(6, true)).isEqualTo(Rank.FIRST);
        assertThat(Rank.rank(6, false)).isEqualTo(Rank.FIRST);
    }

}