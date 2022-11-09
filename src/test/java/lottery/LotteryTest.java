package lottery;

import org.junit.jupiter.api.Test;

import static lottery.TestLotteryFactory.createLottery;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryTest {

    @Test
    void create_6개미만() {
        assertThatThrownBy(() -> createLottery(1, 2, 3, 4, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create_6개초과() {
        assertThatThrownBy(() -> createLottery(1, 2, 3, 4, 5, 6, 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create_중복값() {
        assertThatThrownBy(() -> createLottery(1, 1, 2, 3, 4, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
