package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    @DisplayName("로또 당첨 등수 테스트")
    void rankTest() {
        assertThat(Rank.valueOf(0)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(3)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(4)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(6)).isEqualTo(Rank.FIRST);
    }
}
