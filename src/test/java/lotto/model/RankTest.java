package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void ranks() {
        assertThat(Rank.ranks())
                .containsExactly(Rank.FOUR, Rank.THREE, Rank.TWO, Rank.ONE)
                .isNotIn(Rank.NO_MATCH);
    }

    @Test
    void find() {
        assertThat(Rank.find(6))
                .isEqualTo(Rank.ONE);
        assertThat(Rank.find(2))
                .isEqualTo(Rank.NO_MATCH);
    }

}
