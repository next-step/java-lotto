package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    @DisplayName("로또 당첨 등수 테스트")
    void rankTest() {
        assertThat(Rank.valueOf(0,false)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(3,false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(5,false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(5,true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(6,false)).isEqualTo(Rank.FIRST);
    }
}
