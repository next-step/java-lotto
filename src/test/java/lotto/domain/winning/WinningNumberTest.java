package lotto.domain.winning;

import lotto.domain.winning.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created By mand2 on 2020-11-19.
 */
class WinningNumberTest {

    @Test
    @DisplayName("당첨번호를 입력한다")
    void test() {
        // given
        String inputNumber = "1, 2, 3, 4, 5, 6";

        // when
        WinningNumber winningNumber = WinningNumber.of(inputNumber);

        // then
        assertThat(winningNumber.value()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
