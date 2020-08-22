package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("Rank 테스트")
    void rankTest() {
        assertThat(Rank.valudOf(4)).isEqualTo(Rank.THIRD);
        assertThat(Rank.FIRST.getWinningMoney()).isEqualTo(2_000_000_000);
    }

}
