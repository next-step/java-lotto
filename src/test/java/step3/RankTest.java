package step3;

import org.junit.jupiter.api.Test;
import step3.domain.Rank;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    void rank_1등() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
    }

    @Test
    void rank_2등() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    void rank_3등() {
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    void rank_4등() {
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
    }

    @Test
    void rank_5등() {
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
    }

    @Test
    void rank_꽝() {
        assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.MISS);
    }
}
