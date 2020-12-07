package lottery.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TestLotteryResult {
    @Test
    void create() {
        LotteryResult lotteryResult = new LotteryResult("1,2,3,4,5,6");
        assertThat(lotteryResult).isInstanceOf(LotteryResult.class);
    }

    @Test
    void update() {
        LotteryResult lotteryResult = new LotteryResult("1,2,3,4,5,6");
        lotteryResult.addLotteryResult(3);
        assertThat(lotteryResult.lotteryResultMap.get(LotteryValue.FORTH_PLACE)).isEqualTo(1);
    }
}
