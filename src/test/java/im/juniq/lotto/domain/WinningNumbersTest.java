package im.juniq.lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @Test
    @DisplayName("당첨번호에 포함되는 숫자인지 확인")
    void existWinningNumber() {
        assertThat(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7).existent(1)).isEqualTo(true);
        assertThat(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7).existent(7)).isEqualTo(false);
    }

    @Test
    @DisplayName("보너스번호와 일치하는 숫자인지 확인")
    void matchedBonusNumber() {
        assertThat(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7).matchedBonusNumber(7)).isEqualTo(true);
        assertThat(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7).matchedBonusNumber(1)).isEqualTo(false);
    }
}
