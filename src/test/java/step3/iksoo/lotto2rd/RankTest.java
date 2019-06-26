package step3.iksoo.lotto2rd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void _2등_보너스볼() {
        assertThat(Rank.valueOf(5, true).getWinningMoney()).isEqualTo(Rank.SECOND.getWinningMoney());
    }
}
