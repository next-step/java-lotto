package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("Rank 테스트")
    void rankTest() {
        assertThat(Rank.valudOf(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.FIRST.getWinningMoney()).isEqualTo(2_000_000_000);
    }

    @Test
    @DisplayName("2등, 3등 확인")
    void secondAndThirdTest() {
        assertThat(Rank.valudOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valudOf(5, false)).isEqualTo(Rank.THIRD);
    }
}
