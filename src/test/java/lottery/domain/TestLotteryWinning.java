package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestLotteryWinning {
    @Test
    void create() {
        LotteryWinning lotteryWinning = new LotteryWinning("1,2,3,4,5,6", "7");
        assertThat(lotteryWinning).isInstanceOf(LotteryWinning.class);
        assertThat(lotteryWinning).isEqualTo(new LotteryWinning("1,2,3,4,5,6", "7"));
    }

    @Test
    @DisplayName("6개 모두 일치하는 경우")
    void getCountsMatchedAll() {
        LotteryWinning lotteryWinning = new LotteryWinning("1,2,3,4,5,6", "7");
        assertThat(lotteryWinning.getCountsMatched(LotteryTicket.manual("1,2,3,4,5,6"))).isEqualTo(6);
    }

    @Test
    @DisplayName("0개 일치하는 경우")
    void getCountsMatchedNoting() {
        LotteryWinning lotteryWinning = new LotteryWinning("1,2,3,4,5,6", "7");
        assertThat(lotteryWinning.getCountsMatched(LotteryTicket.manual("10,11,12,13,14,15"))).isEqualTo(0);
    }
}
