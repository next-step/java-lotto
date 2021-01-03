package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void match_1등() {
        assertThat(Rank.valueOf(6,true)).isEqualTo(Rank.FIRST);
    }

    @Test
    void match_2등() {
        assertThat(Rank.valueOf(5,true)).isEqualTo(Rank.SECOND);
    }

    @Test
    void match_3등() {
        assertThat(Rank.valueOf(5,false)).isEqualTo(Rank.THIRD);
    }
}