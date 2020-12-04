package lotto.context;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void getCountOfMatch() {
        Assertions.assertThat(Rank.FIRST.getCountOfMatch())
                .isEqualTo(6);
    }

    @Test
    void getWinningMoney() {
        Assertions.assertThat(Rank.FIRST.getWinningMoney())
                .isEqualTo(2_000_000_000);
    }

    @Test
    void getRank() {
        Assertions.assertThat(Rank.getRank(6, false))
                .isEqualTo(Rank.FIRST);
    }

    @Test
    void getRank_NotMatch() {
        Assertions.assertThat(Rank.getRank(1, false))
                .isEqualTo(Rank.MISS);
    }
}