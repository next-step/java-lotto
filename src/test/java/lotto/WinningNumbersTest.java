package lotto;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class WinningNumbersTest {
    @Test
    void 당첨번호_객체_생성_성공() {
        // given, when, then
        assertDoesNotThrow(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7));
    }
}
