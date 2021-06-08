package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("1등")
    @Test
    void First() {
        assertThat(Rank.getRank(6, false)).isSameAs(Rank.FIRST);
    }

    @DisplayName("2등")
    @Test
    void SECOND() {
        assertThat(Rank.getRank(5, true)).isSameAs(Rank.SECOND);
    }

    @DisplayName("3등")
    @Test
    void THIRD() {
        assertThat(Rank.getRank(5, false)).isSameAs(Rank.THIRD);
    }

    @DisplayName("4등_false")
    @Test
    void FOURTH_false() {
        assertThat(Rank.getRank(4, false)).isSameAs(Rank.FOURTH);
    }

    @DisplayName("5등_false")
    @Test
    void FIFTH_false() {
        assertThat(Rank.getRank(3, false)).isSameAs(Rank.FIFTH);
    }

    @DisplayName("4등_true")
    @Test
    void FOURTH_true() {
        assertThat(Rank.getRank(4, true)).isSameAs(Rank.FOURTH);
    }

    @DisplayName("5등_true")
    @Test
    void FIFTH_tru() {
        assertThat(Rank.getRank(3, true)).isSameAs(Rank.FIFTH);
    }

    @DisplayName("꽝")
    @Test
    void MISS() {
        assertThat(Rank.getRank(0, false)).isSameAs(Rank.MISS);
    }

}
