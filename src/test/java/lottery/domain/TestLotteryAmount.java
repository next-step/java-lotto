package lottery.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TestLotteryAmount {
    @Test
    void create() {
        LotteryAmount lotteryAmount = new LotteryAmount(1000, 0);
        assertThat(lotteryAmount).isEqualTo(new LotteryAmount(1000, 0));
    }

    @Test
    void invalid_price() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           LotteryAmount lotteryAmount = new LotteryAmount(0, 0);
        });
    }

    @Test
    void invalid_price_and_exceed_manual() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LotteryAmount lotteryAmount = new LotteryAmount(1000, 2);
        });
    }

    @Test
    void get_amount_of_lottery_tickets() {
        LotteryAmount lotteryAmount = new LotteryAmount(5000, 2);
        assertThat(lotteryAmount.getAuto()).isEqualTo(3);
        assertThat(lotteryAmount.getManual()).isEqualTo(2);
    }
}
