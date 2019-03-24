package lottery.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {

    @Test
    public void 당첨번호_맞는지_체크() {
        Lottery lottery = new Lottery(Arrays.asList(2,3,4,4,3,4));
        Lottery mockLottery = new Lottery(Arrays.asList(2,3,4,4,3,4));
        int result = lottery.winCheck(mockLottery);
        assertThat(result) .isEqualTo(1);
    }
}