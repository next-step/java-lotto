package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

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

    @DisplayName("miss 테스트")
    @ParameterizedTest
    @CsvSource(value = {"11,12,13,14,15,16|1", "1,12,13,14,15,16|1", "1,2,13,14,15,16|1", "1,2,3,14,15,16|0"}, delimiter = '|')
    void miss(String stringNumbers, int miss) {
        winningNumber.draw();

        Integer[] numbers = Arrays.stream(stringNumbers.split(",")) //
                .map(Integer::valueOf) //
                .toArray(Integer[]::new);
        LotteryResult lotteryResult = winningNumber.match(makeLotteryTickets(numbers));

        assertThat(lotteryResult.getMiss()).isEqualTo(miss);
    }

    @DisplayName("3개 일치 테스트")
    @Test
    void threeMatched() {
        winningNumber.draw();

        //@formatter:off
        LotteryResult lotteryResult = winningNumber.match(new LotteryTickets(
                Arrays.asList(
                        LotteryNumber.of(1, 2, 3, 14, 15, 16), // 3개 일치
                        LotteryNumber.of(1, 2, 3, 14, 15, 16), // 3개 일치
                        LotteryNumber.of(11, 12, 13, 14, 15, 16)))); // 불일치
        //@formatter:on

        assertThat(lotteryResult.getThreeMatched()).isEqualTo(2);
    }

    private LotteryTickets makeLotteryTickets(Integer... numbers) {
        return new LotteryTickets(singletonList(LotteryNumber.of(numbers)));
    }

    static class WinningNumber {
        private final NumberSelection numberSelection;
        private LotteryNumber winningNumber;

        public WinningNumber(NumberSelection numberSelection) {
            this.numberSelection = numberSelection;
        }

        public LotteryResult match(LotteryTickets tickets) {
            if (winningNumber == null) {
                throw new IllegalStateException();
            }

            LotteryResult lotteryResult = new LotteryResult();
            for (LotteryNumber ticketNumber : tickets.getNumbers()) {
                lotteryResult.add(ticketNumber.getMatched(winningNumber));
            }

            return lotteryResult;
        }

        public void draw() {
            winningNumber = numberSelection.select(NUMBER_POOL);
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
            return LotteryNumber.of(numbers);
        }
    }

    static class LotteryResult {
        private int miss;
        private int threeMatched;

        public int getMiss() {
            return miss;
        }

        public void add(int matched) {
            if (matched < 3) {
                miss++;
            }
            if (matched == 3) {
                threeMatched++;
            }
        }

        public int getThreeMatched() {
            return threeMatched;
        }
    }
}
