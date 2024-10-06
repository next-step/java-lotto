package lotto.domain;

import lotto.constant.Prize;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningPrizeTest {

    @Test
    void 당첨금() {
        WinningPrize prize = new WinningPrize();

        prize.add(Prize.FIRST);
        prize.add(Prize.SECOND);
        prize.add(Prize.THIRD);
        prize.add(Prize.THIRD);
        prize.add(Prize.FOURTH);
        prize.add(Prize.FOURTH);

        assertThat(prize.winAmount(Prize.FIRST)).isEqualTo(1);
        assertThat(prize.winAmount(Prize.SECOND)).isEqualTo(1);
        assertThat(prize.winAmount(Prize.THIRD)).isEqualTo(2);
        assertThat(prize.winAmount(Prize.FOURTH)).isEqualTo(2);
    }
}
