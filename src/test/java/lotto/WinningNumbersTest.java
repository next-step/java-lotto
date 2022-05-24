package lotto;

import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {
    @Test
    void 유효성검사() {
        assertThatThrownBy(() -> {
            WinningNumbers winningNumbers = WinningNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
