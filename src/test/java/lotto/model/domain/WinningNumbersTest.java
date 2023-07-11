package lotto.model.domain;


import lotto.model.domain.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningNumbersTest {
    @Test
    void 당첨번호_객체_생성_성공() {
        // given, when, then
        assertDoesNotThrow(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7));
    }

    @Test
    void 당첨번호에_중복된_번호가_있을때_생성_실패() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 5);
        // when, then
        assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(winningNumbers, 7));
    }

    @Test
    void 당첨번호에_번호가_6개가_아닐때_생성_실패() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        // when, then
        assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(winningNumbers, 8));
    }

    @Test
    void 당첨번호와_보너스볼이_중복되면_생성_실패() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when, then
        assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(winningNumbers, 6));
    }
}
