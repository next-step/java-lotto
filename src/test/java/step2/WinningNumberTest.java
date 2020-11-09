package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.LotteryAgentTest.LotteryTickets;
import static step2.LotteryNumberTest.LotteryNumber;
import static step2.PlayslipTest.Playslip.NUMBER_POOL;
import static step2.WinningNumberTest.LotteryResult.Matched;
import static step2.WinningNumberTest.LotteryResult.Matched.*;


public class WinningNumberTest {

    private WinningNumber winningNumber;

    @BeforeEach
    void setUp() {
        winningNumber = new WinningNumber(new TestingNumberSelection(1, 2, 3, 4, 5, 6));
        winningNumber.draw();
    }

    @DisplayName("draw 하기 전에 match 할 수 없다.")
    @Test
    void cannotMatchWithoutDraw() {
        WinningNumber winningNumber = new WinningNumber(new TestingNumberSelection(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> winningNumber.match(makeLotteryTickets(1, 2, 3, 4, 5, 6))) //
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("match 결과를 받을 수 있다.")
    @Test
    void matchResult() {
        assertThat(winningNumber.match(makeLotteryTickets(1, 2, 3, 4, 5, 6))).isNotNull();
    }

    @DisplayName("miss 테스트")
    @ParameterizedTest
    @CsvSource(value = {"11,12,13,14,15,16|1", "1,12,13,14,15,16|1", "1,2,13,14,15,16|1", "1,2,3,14,15,16|0"}, delimiter = '|')
    void miss(String stringNumbers, int miss) {
        Integer[] numbers = Arrays.stream(stringNumbers.split(",")) //
                .map(Integer::valueOf) //
                .toArray(Integer[]::new);
        LotteryResult lotteryResult = winningNumber.match(makeLotteryTickets(numbers));

        assertThat(lotteryResult.getMatchResult(Matched.miss)).isEqualTo(miss);
    }

    @DisplayName("3개 ~ 6개 일치 테스트")
    @ParameterizedTest
    @MethodSource("matchingCountProvider")
    void matched(LotteryNumber lotteryNumber, Matched matched) {
        //@formatter:off
        LotteryResult lotteryResult = winningNumber.match(new LotteryTickets(
                Arrays.asList(
                        lotteryNumber,
                        lotteryNumber,
                        LotteryNumber.of(11, 12, 13, 14, 15, 16)))); // 불일치
        //@formatter:on

        assertThat(lotteryResult.getMatchResult(matched)).isEqualTo(2);
    }

    private static Stream<Arguments> matchingCountProvider() {
        //@formatter:off
        return Stream.of(
                Arguments.of(LotteryNumber.of(1, 2, 3, 14, 15, 16), three),
                Arguments.of(LotteryNumber.of(1, 2, 3, 4, 15, 16), four),
                Arguments.of(LotteryNumber.of(1, 2, 3, 4, 5, 16), five),
                Arguments.of(LotteryNumber.of(1, 2, 3, 4, 5, 6), six)
        );
        //@formatter:on
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
        enum Matched {
            miss(0), three(3), four(4), five(5), six(6);

            private final int matchingCount;

            Matched(int matchingCount) {
                this.matchingCount = matchingCount;
            }

            public static Matched valueBy(Supplier<Integer> matched) {
                return Arrays.stream(values()) //
                        .filter(value -> value.matchingCount == matched.get()) //
                        .findFirst().orElseThrow(IllegalArgumentException::new);
            }
        }

        private final Map<Matched, Integer> result = new HashMap<>();

        public void add(int matched) {
            Matched matchedEnum = Matched.valueBy(() -> {
                if (matched < 3) {
                    return 0;
                } return matched;
            });

            result.compute(matchedEnum, (key, value) -> value == null ? 1 : value + 1);
        }

        public int getMatchResult(Matched matched) {
            return result.getOrDefault(matched, 0);
        }
    }
}
