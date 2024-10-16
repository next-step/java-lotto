package lotto.enumeration;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @Test
    void 일치하는_개수로_당첨_금액_찾기() {
        assertThat(Rank.price(6)).isEqualTo(2000000000);
    }
}