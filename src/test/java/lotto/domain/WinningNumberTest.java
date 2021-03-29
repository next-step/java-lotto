package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberTest {

    @DisplayName("당첨번호 6개의 숫자로 이루어짐")
    @ParameterizedTest
    @MethodSource("provideWinningNumbers")
    void winningNumber_숫자6개구성(String lottoNumber, int bonusNumber, String expectedLottoNumber, int expectedBonusNumber) {
        WinningNumber winningNumberInput = WinningNumber.of(lottoNumber, bonusNumber);
        WinningNumber winningNumberExpeced = WinningNumber.of(expectedLottoNumber, expectedBonusNumber);
        assertThat(winningNumberInput).isEqualTo(winningNumberExpeced);
    }

    private static Stream<Arguments> provideWinningNumbers() {
        return Stream.of(
                Arguments.of("1, 3, 5, 7, 9, 11", 10, "1, 3, 5, 7, 9, 11", 10),
                Arguments.of("5, 10, 13, 17, 29, 31", 15, "5, 10, 13, 17, 29, 31", 15),
                Arguments.of("21, 33, 34, 37, 40, 45", 20, "21, 33, 34, 37, 40, 45", 20)
        );
    }

    @DisplayName("당첨번호와 로또번호 조회하여 몇개 일치하는지 테스트")
    @ParameterizedTest
    @MethodSource("provideLottos")
    void getLottoMatchCount(int[] input, int bonusNumber, int expected) {
        String winningNumbers = "1, 3, 5, 7, 9, 11";
        WinningNumber winningNumber = WinningNumber.of(winningNumbers, bonusNumber);

        Set<Integer> lottoSet = new TreeSet<>(Arrays.stream(input)
                .boxed()
                .collect(Collectors.toSet()));
        Lotto lotto = Lotto.of(lottoSet);

        assertThat(winningNumber.getLottoMatchCount(lotto)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottos() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 7, 9, 11}, 10, 6),
                Arguments.of(new int[]{1, 3, 5, 7, 9, 45}, 12, 5),
                Arguments.of(new int[]{1, 3, 5, 7, 10, 43}, 15, 4)
        );
    }
}
