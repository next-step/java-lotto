package im.juniq.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    void existWinningNumber() {
        assertThat(new WinningNumbers(1, 2, 3, 4, 5, 6).existent(1)).isEqualTo(true);
        assertThat(new WinningNumbers(1, 2, 3, 4, 5, 6).existent(7)).isEqualTo(false);
    }
}
