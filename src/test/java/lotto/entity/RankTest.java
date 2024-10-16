package lotto.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RankTest {

    @Test
    void 맞히지_못함() {
        Rank rank = Rank.valueOf(2, true);
        assertThat(rank).isEqualTo(Rank.MISS);
    }

    @Test
    void 당첨() {
        assertAll(
                () -> assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH),
                () -> assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH),
                () -> assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD),
                () -> assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND),
                () -> assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST)
        );
    }
}
