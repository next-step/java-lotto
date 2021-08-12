import Lotto.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {


    @Test
    @DisplayName("당첨번호를 입력받을시 6자리가 아니면 예외를발생한다")
    void winningNumberOverSixException() {
        String[] numbers = "1,2,3,4,5,6,7".split(",");

        assertThatThrownBy(() -> WinningNumber.of(numbers)).isInstanceOf(IllegalArgumentException.class);


    }

    @Test
    @DisplayName("당첨번호를 입력받을시 6자리이면 통과한다")
    void winningNumberSizeSixPass() {
        String[] numbers = "1,2,3,4,5,6".split(",");

        assertThat(WinningNumber.of(numbers).getSize()).isEqualTo(6);

    }

    @Test
    @DisplayName("당첨번호를 입력받을시 1이하 45초과이면 예외를 발생한다.")
    void oneUnderFourtyFiveOverException() {
        String[] numbers = "1,2,3,4,5,88".split(",");

        assertThatThrownBy(() -> WinningNumber.of(numbers)).hasMessageContaining("IllegalArgumentException");

    }
}
