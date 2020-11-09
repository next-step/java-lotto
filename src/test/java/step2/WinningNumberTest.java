package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.LotteryAgentTest.LotteryTickets;
import static step2.LotteryNumberTest.LotteryNumber;
import static step2.PlayslipTest.Playslip.NUMBER_POOL;


public class WinningNumberTest {

    private WinningNumber winningNumber;

    @BeforeEach
    void setUp() {
        winningNumber = new WinningNumber(new TestingNumberSelection(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("draw 하기 전에 match 할 수 없다.")
    @Test
    void cannotMatchWithoutDraw() {
        assertThatThrownBy(() -> winningNumber.match(makeLotteryTickets(1, 2, 3, 4, 5, 6))) //
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("match 결과를 받을 수 있다.")
    @Test
    void matchResult() {
        winningNumber.draw();
        assertThat(winningNumber.match(makeLotteryTickets(1, 2, 3, 4, 5, 6))).isNotNull();
    }

    private LotteryTickets makeLotteryTickets(Integer... numbers) {
        return new LotteryTickets(singletonList(new LotteryNumber(new HashSet<>(asList(numbers)))));
    }

    private static class WinningNumber {
        private final NumberSelection numberSelection;
        private LotteryNumber lotteryNumber;

        public WinningNumber(NumberSelection numberSelection) {
            this.numberSelection = numberSelection;
        }

        public LotteryResult match(LotteryTickets tickets) {
            if (lotteryNumber == null) {
                throw new IllegalStateException();
            }
            return new LotteryResult();
        }

        public void draw() {
            lotteryNumber = numberSelection.select(NUMBER_POOL);
        }

        private static class LotteryResult {
        }
    }

    private interface NumberSelection {
        LotteryNumber select(List<Integer> numberPool);
    }

    private static class TestingNumberSelection implements NumberSelection {
        private final Integer[] numbers;

        public TestingNumberSelection(Integer... numbers) {
            this.numbers = numbers;
        }

        @Override
        public LotteryNumber select(List<Integer> numberPool) {
            return new LotteryNumber(new HashSet<>(Arrays.asList(numbers)));
        }
    }
}
