package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @DisplayName("당첨번호는_1~45범위이고_6개이다")
    @Test
    void validateWinningNumbers() {
        final int bonusBall = 12;
        assertDoesNotThrow(() -> new WinningNumbers(Arrays.asList(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)), new LottoNumber(bonusBall)));
    }

    @DisplayName("보너스볼의 범위는 1~45까지이다.")
    @Test
    void validateBonusBallRange() {
        final int bonusBall = 78;
        assertThrows(IllegalArgumentException.class,
            () -> new WinningNumbers(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(3),
                new LottoNumber(2),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)), new LottoNumber(bonusBall)));
    }
}
