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
    public void 당첨조회한장() {
        Lottery mockLottery = Fixture.oneToSixBonusBallLottery;

        List<Lottery> lotteries = Arrays.asList(Fixture.oneToSixLottery);
        LotteryResult result = lotteryMachine.checkWinning(lotteries, mockLottery);
        assertThat(result).isEqualTo(new LotteryResult(Arrays.asList(RANK.FIRST)));
    }

    @Test
    public void 당첨조회두장() {
        Lottery rankMissLottery = new Lottery(new LotteryNumber(Arrays.asList(15,28,30,35,41,45)));
        
        List<Lottery> lotteries = Arrays.asList(Fixture.oneToSixLottery,rankMissLottery);
        LotteryResult result = lotteryMachine.checkWinning(lotteries, new Lottery(new LotteryNumber(Arrays.asList(1,2,3,8,9,10),11)));
        assertThat(result).isEqualTo(new LotteryResult(Arrays.asList(RANK.FIFTH, RANK.MISS)));
    }
}