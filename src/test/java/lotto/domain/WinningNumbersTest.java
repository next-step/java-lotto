package lotto.domain;

import static lotto.util.Constant.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @DisplayName("당첨번호는_1~45범위이고_6개이다")
    @Test
    void validateWinningNumbers() {
        final int bonusBall = 12;
        assertDoesNotThrow(() -> new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), bonusBall));
    }

    @DisplayName("보너스볼의 범위는 1~45까지이다.")
    @Test
    void validateBonusBallRange() {
        final int bonusBall = 78;
        assertThrows(IllegalArgumentException.class,
            () -> new WinningNumbers(Arrays.asList(1, 2, 3, 2, 5, 6), bonusBall));
    }
}