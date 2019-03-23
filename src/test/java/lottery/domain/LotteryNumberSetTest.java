package lottery.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryNumberSetTest {
    private  LotteryNumberSet lotteryNumberSet;
    
    @Test
    public void 숫자세팅테스트() {
        lotteryNumberSet = new LotteryNumberSet();
        int result = lotteryNumberSet.lotteryNumbers.size();
        assertThat(result).isEqualTo(45);
    }
}