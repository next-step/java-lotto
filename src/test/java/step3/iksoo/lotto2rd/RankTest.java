package step3.iksoo.lotto2rd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void _2등_보너스볼_당첨() {
        assertThat(Rank.valueOf(5, true).getWinningMoney()).isEqualTo(Rank.SECOND.getWinningMoney());
    }

    @Test
    void _4등_당첨() {
        assertThat(Rank.valueOf(4, false).getWinningMoney()).isEqualTo(Rank.FOURTH.getWinningMoney());
    }
}
