package lottery.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryMachineTest {

    private static LotteryMachine lotteryMachine;

    @Before
    public void setUp() {
        lotteryMachine = new LotteryMachine(new LotteryNumberSet() {
            @Override
            List<Integer> suffle(List<Integer> lotteryNumbers) {
                return Arrays.asList(1,2,3,4,5,6);
            }
        });
    }

    @Test
    public void 로또한장구입() {
        List<Lottery> myLotto = lotteryMachine.purchaseLotteries(1000);
        assertThat(myLotto.get(0).toString()).isEqualTo(new Lottery(Arrays.asList(1,2,3,4,5,6)).toString());
    }

    @Test
    public void 로또두장구입() {
        List<Lottery> myLotto = lotteryMachine.purchaseLotteries(2000);
        assertThat(myLotto.size()).isEqualTo(2);
    }

    @Test
    public void 당첨조회한장() {
        List<Lottery> lotteries = lotteryMachine.purchaseLotteries(1000);
        LotteryResult result = lotteryMachine.checkWinning(lotteries, Arrays.asList(1,2,3,4,5,6));
        assertThat(result).isEqualTo(new LotteryResult(Arrays.asList(6)));

        result = lotteryMachine.checkWinning(lotteries, Arrays.asList(4,5,6,7,8,9));
        assertThat(result).isEqualTo(new LotteryResult(Arrays.asList(3)));
    }

    @Test
    public void 당첨조회두장() {
        lotteryMachine.purchaseLotteries(2000);
        LotteryResult result = lotteryMachine.checkWinning(lotteryMachine.getLotteries(), Arrays.asList(1,2,3,4,5,6));
        assertThat(result).isEqualTo(new LotteryResult(Arrays.asList(6,6)));
    }
}