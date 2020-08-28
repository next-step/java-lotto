package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("Rank 1등 테스트")
    void rankFirst() {
        assertThat(Rank.valudOf(6, false)).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("Rank 2등 테스트")
    void rankSecond() {
        assertThat(Rank.valudOf(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("Rank 3등 테스트")
    void rankThird() {
        assertThat(Rank.valudOf(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("Rank 4등 테스트")
    void rankFourth() {
        assertThat(Rank.valudOf(4, false)).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("Rank 5등 테스트")
    void rankFifth() {
        assertThat(Rank.valudOf(3, false)).isEqualTo(Rank.FIFTH);
    }

}
