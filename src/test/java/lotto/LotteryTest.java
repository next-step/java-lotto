package lotto;

import lotto.domain.Lottery;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class LotteryTest {
    @Test
    void 당첨번호와_일치하는_번호_개수_구하기() {
        // given
        Lottery winningLottery = new Lottery(Set.of(1, 2, 3, 4, 5, 6));
        Lottery lottery = new Lottery(Set.of(1, 2, 10, 11, 12, 13));

        // when
        int equalNumberCount = lottery.countWinningNumbers(winningLottery);

        // then
        Assertions.assertThat(equalNumberCount).isEqualTo(2);
    }
}
