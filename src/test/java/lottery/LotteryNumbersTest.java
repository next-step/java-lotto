package lottery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LotteryNumbersTest {

    @Test
    @DisplayName("6개의 로또번호를 가진다.")
    void lotteryNumber_test() {
        LotteryNumbers lotteryNumbers = new LotteryNumbers(1, 2, 3, 4, 5, 6);

        assertThat(lotteryNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또번호의 개수가 6개가 아닌 경우 예외처리한다.")
    void notSixDigitLotteryNumber_test() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LotteryNumbers(1, 2, 3, 4, 5, 6, 9));
    }
}
