package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void match_1등() {
        assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST);
    }

    @Test
    void match_2등() {
        assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    void match_3등() {
        assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    void match_4등() {
        assertThat(Rank.of(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.of(4, true)).isEqualTo(Rank.FOURTH);
    }

    @Test
    void match_5등() {
        assertThat(Rank.of(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.of(3, true)).isEqualTo(Rank.FIFTH);
    }

    @Test
    void match_꽝() {
        assertThat(Rank.of(2, false)).isEqualTo(Rank.NO_MATCH);
        assertThat(Rank.of(2, true)).isEqualTo(Rank.NO_MATCH);
    }
}
