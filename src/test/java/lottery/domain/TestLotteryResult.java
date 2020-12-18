package lottery.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TestLotteryResult {
    @Test
    void create() {
        LotteryResult lotteryResult = new LotteryResult();
        assertThat(lotteryResult).isInstanceOf(LotteryResult.class);
    }

    @Test
    void update_with_no_matched_bonus() {
        LotteryResult lotteryResult = new LotteryResult();
        lotteryResult.updateLotteryResult(3, false);
        assertThat(lotteryResult.getLotteryResultMap().get(LotteryValue.FIFTH_PLACE)).isEqualTo(1);
    }

    @Test
    void update_with__matched_bonus() {
        LotteryResult lotteryResult = new LotteryResult();
        lotteryResult.updateLotteryResult(5, true);
        assertThat(lotteryResult.getLotteryResultMap().get(LotteryValue.SECOND_PLACE)).isEqualTo(1);
    }
}
