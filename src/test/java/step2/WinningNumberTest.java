package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class WinningNumberTest {
    @DisplayName("번호 선택방법을 제공받는다.")
    @Test
    void constructWithNumberSelection() {
        assertThatCode(() -> new WinningNumber(new TestingNumberSelection(1, 2, 3, 4, 5, 6))) //
                .doesNotThrowAnyException();
    }

    @DisplayName("draw 하기 전에 match 할 수 없다.")
    @Test
    void matchWithLotteryTicket() {
        WinningNumber winningNumber = new WinningNumber(new TestingNumberSelection(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> winningNumber.match(makeLotteryTickets(1, 2, 3, 4, 5, 6))) //
                .isInstanceOf(IllegalStateException.class)
    }

    private static class WinningNumber {
        public WinningNumber(NumberSelection numberSelection) {
        }
    }

    private interface NumberSelection {
    }

    private static class TestingNumberSelection implements NumberSelection {
        public TestingNumberSelection(int... numbers) {
        }
    }
}
