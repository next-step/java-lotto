package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Rank;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    void rank_1등() {
        assertThat(Rank.rank(6)).isEqualTo(Rank.FIRST);
    }

    @Test
    void rank_2등() {
        assertThat(Rank.rank(5)).isEqualTo(Rank.SECOND);
    }

    @Test
    void rank_3등() {
        assertThat(Rank.rank(4)).isEqualTo(Rank.THIRD);
    }

    @Test
    void rank_4등() {
        assertThat(Rank.rank(3)).isEqualTo(Rank.FOURTH);
    }
}
