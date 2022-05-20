package lotto;

import lotto.model.*;
import lotto.model.Winning;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTest {
    Lottery answer = new Lottery(Lottery.toLotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    Winning winning = new Winning(answer, 7);
    Lottery myLottery = new Lottery(Lottery.toLotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 7)));

    @Test
    void evaluateBonus() {
        assertThat(winning.bonus(myLottery.lotteryNumbers).isPresent()).isTrue();
    }

    @Test
    void matchWinReturnBonus() {
        assertThat(winning.matchWin(myLottery.lotteryNumbers)).isEqualTo(Reward.of(5, true));
    }

    @Test
    void shouldCount1() {
        assertThat(winning.countWin(new LotteryNumber(1))).isEqualTo(1);
    }
}
