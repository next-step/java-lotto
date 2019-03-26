package lotto;

import lotto.domain.*;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryMachineTest {
    final Set<Integer> lotteryNumber = new HashSet<>(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));

    @Test
    public void 로또_맞춘_개수_테스트() {

        Lottery lottery = new Lottery(lotteryNumber);

        Set<Integer> winnerLottery = new HashSet<>(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        lottery.generationLottery(winnerLottery);

        assertThat(lottery.matchNumber(3, 4)).isEqualTo(4);
    }
    @Test
    public void 로또_일등_테스트() {
        Lottery lottery = new Lottery(lotteryNumber);

        Set<Integer> inputLottery = new HashSet<>(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        Set<Integer> winnerLottery = new HashSet<>(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));

        LotteryMachine lotteryMachine = new LotteryMachine(winnerLottery);

        lottery.generationLottery(inputLottery);

        assertThat(lotteryMachine.rankLottery(lottery)).isEqualTo(Ranking.FIRST_CLASS);
    }

    @Test
    public void 로또_상금_테스트() {
        Lottery lottery = new Lottery(lotteryNumber);

        Set<Integer> inputLottery = new HashSet<>(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        Set<Integer> winnerLottery = new HashSet<>(new ArrayList<>(Arrays.asList(1,2,3,11,12,13)));

        LotteryMachine lotteryMachine = new LotteryMachine(winnerLottery);

        lottery.generationLottery(inputLottery);

        assertThat(lotteryMachine.countProfit(lottery)).isEqualTo(5000);
    }
}
