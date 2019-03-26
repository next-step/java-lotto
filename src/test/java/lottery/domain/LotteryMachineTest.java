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
        lotteryMachine = new LotteryMachine();
    }

    @Test
    public void 로또한장구입() {
        List<Lottery> myLotto = lotteryMachine.purchaseLotteries(1000);
        assertThat(myLotto.size()).isEqualTo(1);
    }

    @Test
    public void 로또두장구입() {
        List<Lottery> myLotto = lotteryMachine.purchaseLotteries(2000);
        assertThat(myLotto.size()).isEqualTo(2);
    }

    @Test
    public void 당첨조회한장() {
        Lottery mockNumbers = new Lottery(Arrays.asList(1,2,3,4,5,6),7);
        List<Lottery> lotteries = Arrays.asList(new Lottery(Arrays.asList(1,2,3,4,5,7)));
        LotteryResult result = lotteryMachine.checkWinning(lotteries, mockNumbers);
        assertThat(result).isEqualTo(new LotteryResult(Arrays.asList(51)));
    }

    @Test
    public void 당첨조회두장() {
        List<Lottery> lotteries = Arrays.asList(new Lottery(Arrays.asList(1,3,5,7,9,11)), new Lottery(Arrays.asList(15,28,30,35,41,45)));
        LotteryResult result = lotteryMachine.checkWinning(lotteries, new Lottery(Arrays.asList(5,6,7,8,9,10),11));
        assertThat(result).isEqualTo(new LotteryResult(Arrays.asList(3,0)));
    }
}