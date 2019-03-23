package lottery.domain;

import org.junit.After;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {
    private  LotteryNumberSet lotteryNumberSet = new LotteryNumberSet();

    @Test
    public void 당첨번호_맞는지_체크() {
        Lottery lottery = new Lottery(Arrays.asList(2,3,4,4,3,4));
        Lottery mockLottery = new Lottery(Arrays.asList(2,3,4,4,3,4));
        int result = lottery.countMatchNumber(mockLottery);
        assertThat(result) .isEqualTo(1);
    }

    @After
    public void tearDown() {
        lotteryNumberSet = null;
    }
}