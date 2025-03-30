package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;


class WinningNumbersTest {

    @ParameterizedTest
    @DisplayName("티켓과 당첨번호를 비교하여 상금을 결정한다")
    @MethodSource("provideWinningNumbers")
    void determinePrizeTest(List<Integer> numbers, LottoPrize expectedLottoPrize) {
        //given
        NumberGenerationStrategy fixedNumberGenerationStrategy = new NumberGenerationStrategy() {
            @Override
            public Set<Integer> generateNumbers() {
                return Set.of(1, 2, 3, 4, 5, 6);
            }
        };
        LottoTicket ticket = new LottoTicket(fixedNumberGenerationStrategy);
        WinningNumbers winningNumbers = new WinningNumbers(numbers);

        //when
        LottoPrize lottoPrize = winningNumbers.determineLottoPrize(ticket);

        //then
        Assertions.assertThat(lottoPrize).isEqualTo(expectedLottoPrize);
    }

    static Stream<Arguments> provideWinningNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), LottoPrize.FIRST_PLACE),
                Arguments.of(List.of(2, 3, 4, 5, 6, 7), LottoPrize.SECOND_PLACE),
                Arguments.of(List.of(3, 4, 5, 6, 7, 8), LottoPrize.THIRD_PLACE),
                Arguments.of(List.of(4, 5, 6, 7, 8, 9), LottoPrize.FOURTH_PLACE),
                Arguments.of(List.of(5, 6, 7, 8, 9, 10), LottoPrize.NONE)
        );
    }

}