package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static step2.domain.Rank.*;


public class WinningNumberTest {

    private WinningNumber winningNumber;

    @BeforeEach
    void setUp() {
        winningNumber = new WinningNumber(LotteryNumber.of(1, 2, 3, 4, 5, 6));
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

        assertThat(lotteryResult.getMatchResult(Rank.MISS)).isEqualTo(miss);
    }

    @DisplayName("3개 ~ 6개 일치 테스트")
    @ParameterizedTest
    @MethodSource("matchingCountProvider")
    void matched(LotteryNumber lotteryNumber, Rank rank) {
        //@formatter:off
        LotteryResult lotteryResult = winningNumber.match(new LotteryTickets(
                Arrays.asList(
                        lotteryNumber,
                        lotteryNumber,
                        LotteryNumber.of(11, 12, 13, 14, 15, 16)))); // 불일치
        //@formatter:on

        assertThat(lotteryResult.getMatchResult(rank)).isEqualTo(2);
    }

    private static Stream<Arguments> matchingCountProvider() {
        //@formatter:off
        return Stream.of(
                Arguments.of(LotteryNumber.of(1, 2, 3, 14, 15, 16), FORTH),
                Arguments.of(LotteryNumber.of(1, 2, 3, 4, 15, 16), THIRD),
                Arguments.of(LotteryNumber.of(1, 2, 3, 4, 5, 16), SECOND),
                Arguments.of(LotteryNumber.of(1, 2, 3, 4, 5, 6), FIRST)
        );
        //@formatter:on
    }

    private LotteryTickets makeLotteryTickets(Integer... numbers) {
        return new LotteryTickets(singletonList(LotteryNumber.of(numbers)));
    }

}
