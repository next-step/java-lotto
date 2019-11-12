package lotto.data;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void contains_bonus() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(0, true)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.MISS);
    }
}
