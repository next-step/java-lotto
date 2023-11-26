package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningLottoTest {
    @Test
    @DisplayName("당첨로또 숫자 갯수가 6개를 초과하는 경우 exception throw")
    void overInputExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto("1, 2, 3, 4, 5, 6, 7", 8));
    }

    @Test
    @DisplayName("당첨로또 중복숫자 입력되는 경우 6개 미만 exception throw")
    void doubleInputExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto("1, 1, 3, 5, 6, 7", 8));
    }

    @Test
    @DisplayName("당첨로또 숫자 범위가 45를 초과하는 경우 exception throw")
    void overRangeTest() {
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto("45, 56, 1, 2, 3, 5", 7));
    }
}
