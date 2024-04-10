package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    @DisplayName("등수 확인1")
    void test01() {
        assertThat(Rank.valueOf("FIRST")).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf("NONE")).isEqualTo(Rank.NONE);
    }

    @Test
    @DisplayName("등수 확인2")
    void test02() {
        assertThat(Rank.findRank(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.findRank(5, false)).isEqualTo(Rank.THIRD);
    }
}
