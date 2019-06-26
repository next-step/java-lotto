package step3.iksoo.lotto2rd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    void getCountOfMatchTest() {
        assertThat(Rank.FIFTH.getCountOfMatch()).isEqualTo(3);
    }

    @Test
    void getWinningMoneyTest() {
        assertThat(Rank.FIFTH.getWinningMoney()).isEqualTo(5_000);
    }

    @Test
    void _2등_보너스볼() {
        assertThat(Rank.valueOf(5, true).getWinningMoney()).isEqualTo(30_000_000);
    }
}
