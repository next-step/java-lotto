package lottery;

import org.junit.jupiter.api.Test;

import static lottery.TestLotteryFactory.createLottery;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryTest {

    @Test
    void create_6개미만() {
        assertThatThrownBy(() -> createLottery(1, 2, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create_중복() {
        assertThatThrownBy(() -> createLottery(1, 1, 2, 3, 4, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
