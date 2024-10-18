package lotto.vo;

import lotto.enumeration.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTest {
    @Test
    void 비교() {
        Winning first = new Winning(Rank.FIRST, 0);
        Winning second = new Winning(Rank.SECOND, 0);

        assertThat(first.compareTo(second)).isEqualTo(-1);
    }
}