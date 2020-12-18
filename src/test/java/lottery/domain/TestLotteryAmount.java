package lottery.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TestLotteryAmount {
    @Test
    void create() {
        LotteryAmount lotteryAmount = new LotteryAmount(1000);
        assertThat(lotteryAmount).isEqualTo(new LotteryAmount(1000));
    }

    @Test
    void invalid_price() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           LotteryAmount lotteryAmount = new LotteryAmount(0);
        });
    }

    @Test
    void get_amount_of_lottery_tickets() {
        LotteryAmount lotteryAmount = new LotteryAmount(5000);
        assertThat(lotteryAmount.getAmount()).isEqualTo(5);
    }
}
