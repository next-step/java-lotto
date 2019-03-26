package lottery.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {

    @Test
    public void 당첨번호_맞는지_체크() {
        Lottery lottery = new Lottery(Arrays.asList(1,2,3,4,5,6));
        Lottery mockLottery = new Lottery(Arrays.asList(1,2,3,4,5,6),7);
        int result = lottery.winCheck(mockLottery);
        assertThat(result) .isEqualTo(6);
    }

    @Test
    public void 보너스볼도체크() {
        Lottery lottery = new Lottery(Arrays.asList(1,2,3,4,5,6));
        Lottery mockLottery = new Lottery(Arrays.asList(1,2,3,4,5,7), 6);
        int result = lottery.winCheck(mockLottery);
        //2등
        assertThat(result) .isEqualTo(51);
    }
}