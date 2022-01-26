package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RankTest {

    @Test
    void getRank() {
        assertThat(Rank.getRank(3)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.getRank(4)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.getRank(6)).isEqualTo(Rank.FIRST);
    }
}