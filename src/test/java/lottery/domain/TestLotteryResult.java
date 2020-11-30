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
    void createWithResult() {
        LotteryResult lotteryResult = new LotteryResult("1,2,3,4,5,6", 3,1);
        assertThat(lotteryResult.lotteryResultMap.get(3)).isEqualTo(1);
    }

    @Test
    void update() {
        LotteryResult lotteryResult = new LotteryResult("1,2,3,4,5,6");
        lotteryResult.addLotteryResult(3,1);
        assertThat(lotteryResult.lotteryResultMap.get(3)).isEqualTo(1);
    }
}
