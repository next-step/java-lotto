package im.juniq.lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @Test
    void existWinningNumber() {
        assertThat(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7).existent(1)).isEqualTo(true);
        assertThat(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7).existent(7)).isEqualTo(false);
    }

    @Test
    void matchedBonusNumber() {
        assertThat(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7).matchedBonusNumber(7)).isEqualTo(true);
        assertThat(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7).matchedBonusNumber(1)).isEqualTo(false);
    }
}
