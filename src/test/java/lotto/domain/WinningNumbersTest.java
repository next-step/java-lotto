package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;


class WinningNumbersTest {

    @Test
    @DisplayName("당첨 번호는 6개가 아닌 경우 에러를 던진다.")
    void invalidWiningNumbersThrow() {
        //given
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5);
        int bonusNumber = 6;

        //when&then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(winningNumbers, bonusNumber))
                .withMessageContaining("당첨 번호는 6개여야 합니다.");

    }

    @ParameterizedTest
    @DisplayName("티켓과 당첨번호를 비교하여 상금을 결정한다")
    @MethodSource("provideWinningNumbers")
    void determinePrizeTest(Set<Integer> ticketNumbers, LottoPrize expectedLottoPrize) {
        //given
        LottoTicket ticket = new LottoTicket(ticketNumbers);
        WinningNumbers winningNumbers = new WinningNumbers(Set.of(1, 2, 3, 4, 5, 6), 8);

        //when
        LottoPrize lottoPrize = winningNumbers.determineLottoPrize(ticket);

        //then
        Assertions.assertThat(lottoPrize).isEqualTo(expectedLottoPrize);
    }

    static Stream<Arguments> provideWinningNumbers() {
        return Stream.of(
                Arguments.of(Set.of(1, 2, 3, 4, 5, 6), LottoPrize.FIRST_PLACE),
                Arguments.of(Set.of(2, 3, 4, 5, 6, 7), LottoPrize.SECOND_PLACE),
                Arguments.of(Set.of(2, 3, 4, 5, 6, 8), LottoPrize.SECOND_PLACE_WITH_BONUS),
                Arguments.of(Set.of(3, 4, 5, 6, 7, 8), LottoPrize.THIRD_PLACE),
                Arguments.of(Set.of(4, 5, 6, 7, 8, 9), LottoPrize.FOURTH_PLACE),
                Arguments.of(Set.of(5, 6, 7, 8, 9, 10), LottoPrize.NONE)
        );
    }

    @Test
    @DisplayName("보너스볼이 당첨번호와 중복되면 에러를 던진다.")
    void duplicateThrow() {
        //given
        int bonusNumber = 6;

        // when & then
        Assertions.assertThatIllegalStateException()
                .isThrownBy(() -> new WinningNumbers(Set.of(1, 2, 3, 4, 5, 6), bonusNumber))
                .withMessageContaining("보너스 볼은 당첨 번호와 중복될 수 없습니다: " + bonusNumber);
    }
}