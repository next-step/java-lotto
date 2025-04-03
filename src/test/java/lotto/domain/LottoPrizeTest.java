package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class LottoPrizeTest {

    @ParameterizedTest
    @DisplayName("당첨번호, 보너스 번호에 따라 등수가 정해진다.")
    @MethodSource("provideWinningNumbers")
    void determinePrizeTest(Set<LottoNumber> numbers, LottoNumber bonusNumber, LottoPrize expectedLottoPrize) {
        //given

        LottoTicket ticket = new LottoTicket(toLottoNumbers(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(numbers, bonusNumber);

        //when
        LottoPrize lottoPrize = winningNumbers.determineLottoPrize(ticket);

        //then
        Assertions.assertThat(lottoPrize).isEqualTo(expectedLottoPrize);
    }

    static Stream<Arguments> provideWinningNumbers() {
        return Stream.of(
                Arguments.of(toLottoNumbers(1, 2, 3, 4, 5, 7), new LottoNumber(6), LottoPrize.SECOND_PLACE_WITH_BONUS),
                Arguments.of(toLottoNumbers(1, 2, 3, 4, 5, 7), new LottoNumber(8), LottoPrize.SECOND_PLACE),
                Arguments.of(toLottoNumbers(1, 2, 3, 4, 7, 8), new LottoNumber(9), LottoPrize.THIRD_PLACE),
                Arguments.of(toLottoNumbers(1, 2, 3, 4, 7, 8), new LottoNumber(5), LottoPrize.THIRD_PLACE),
                Arguments.of(toLottoNumbers(1, 2, 7, 8, 9, 10), new LottoNumber(11), LottoPrize.NONE)
        );
    }

    private static Set<LottoNumber> toLottoNumbers(Integer... numbers) {
        return Arrays.stream(numbers)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

}