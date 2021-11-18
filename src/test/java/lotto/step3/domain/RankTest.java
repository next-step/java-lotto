package lotto.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("매칭수와 보너스볼이 TRUE 면 2등 반환")
    void valueOf() {
        assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
    }
}