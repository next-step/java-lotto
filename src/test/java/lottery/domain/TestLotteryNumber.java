package lottery.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class TestLotteryNumber {
    @Test
    void create() {
        LotteryNumber lotteryNumber = LotteryNumber.of(1);
        assertThat(lotteryNumber).isEqualTo(LotteryNumber.of(1));
    }

    @Test
    void createWithLowerMinNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LotteryNumber lotteryNumber = LotteryNumber.of(0);
        });
    }

    @Test
    void createWithBiggerMaxNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           LotteryNumber lotteryNumber = LotteryNumber.of(46);
        });
    }
}
