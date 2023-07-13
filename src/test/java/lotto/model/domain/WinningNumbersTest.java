package lotto.model.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    void 당첨번호_객체_생성_성공() {
        // given, when, then
        assertDoesNotThrow(() -> new WinningNumbers(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                LottoNumber.of(7)));
    }

    @Test
    void 당첨번호와_보너스볼이_중복되면_생성_실패() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when, then
        assertThrows(IllegalArgumentException.class,
                () -> new WinningNumbers(new Lotto(winningNumbers), LottoNumber.of(6)));
    }
}
