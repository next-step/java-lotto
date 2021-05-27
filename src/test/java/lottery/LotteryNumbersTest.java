package lottery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryNumbersTest {

    @Test
    @DisplayName("6개의 로또번호를 가진다.")
    void lotteryNumber_test() {
        LotteryNumbers lotteryNumbers = new LotteryNumbers(1, 2, 3, 4, 5, 6);

        assertThat(lotteryNumbers.size()).isEqualTo(6);
    }
}
