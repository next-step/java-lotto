package lottery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LotteryNumberTest {

    @Test
    @DisplayName("로또번호는 1 ~ 45 사이의 숫자이다.")
    void validateLotteryNumbers_test() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LotteryNumber(48));
    }
}
