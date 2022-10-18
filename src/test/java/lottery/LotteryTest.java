package lottery;

import org.junit.jupiter.api.Test;

import static lottery.TestLotteryFactory.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryTest {

    @Test
    void generate_수동() {
        assertThatThrownBy(() -> createLottery(1, 2, 3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> createLottery(1, 1, 2, 3, 4, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
