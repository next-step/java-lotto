package lotto;

import lotto.domain.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static lotto.domain.LotteryNo.makeLotteryNos;
import static org.assertj.core.api.Assertions.assertThat;

public class WinnerLotteryTest {
    final Set<LotteryNo> lotteryNumber = makeLotteryNos(Arrays.asList(1, 2, 3, 4, 5, 6));
    static final int BONUS_NUMBER = 7;

    @Test
    public void 로또_일등_테스트() {
        Lottery lottery = new Lottery(lotteryNumber);

        final Set<LotteryNo> inputLottery = makeLotteryNos(Arrays.asList(1, 2, 3, 4, 5, 6));
        final Lottery winner = new Lottery(makeLotteryNos(Arrays.asList(1, 2, 3, 4, 5, 6)));

        WinnerLottery winnerLottery = new WinnerLottery(winner, BONUS_NUMBER);

        lottery.generationLottery(inputLottery);

        assertThat(winnerLottery.rankLottery(lottery)).isEqualTo(Ranking.FIRST_CLASS);
    }
}
