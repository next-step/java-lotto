package domain.lottery;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TestLotteryResult {
    @Test
    void create() {
        LotteryResult lotteryResult = new LotteryResult();
        assertThat(lotteryResult).isInstanceOf(LotteryResult.class);
    }

    @Test
    void createWithResult() {
        LotteryResult lotteryResult = new LotteryResult(3,1);
        assertThat(lotteryResult.lotteryResultMap.get(3)).isEqualTo(1);
    }

    @Test
    void update() {
        LotteryResult lotteryResult = new LotteryResult();
        lotteryResult.update(3,1);
        assertThat(lotteryResult.lotteryResultMap.get(3)).isEqualTo(1);
    }
}
