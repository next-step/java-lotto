package lottery;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TestLotteryNumber {
    @Test
    void create() {
        LotteryNumber lotteryNumber = new LotteryNumber(1);
        assertThat(lotteryNumber).isEqualTo(new LotteryNumber(1));
    }

    @Test
    void createWithLowerMinNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LotteryNumber lotteryNumber = new LotteryNumber(0);
        });
    }

    @Test
    void createWithBiggerMaxNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           LotteryNumber lotteryNumber = new LotteryNumber(46);
        });
    }
}
