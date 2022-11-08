package step2.domain;

import org.junit.jupiter.api.Test;
import step2.view.InputView;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @Test
    void successTest() {
        assertThat(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)).getWinningNumbers())
                .containsAll(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    void failTest() {
        assertThatThrownBy(() -> new WinningNumbers(InputView.createWinningNumbers("1+1")))
                .isInstanceOf(NumberFormatException.class);
    }

}