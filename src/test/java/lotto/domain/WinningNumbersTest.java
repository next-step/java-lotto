package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersTest {

    private static final List<Integer> DEFAULT_WINNING_NUMBER_LIST = Arrays.asList(1, 2, 3, 4, 5,
        6);
    private static final int DEFAULT_BONUS_NUMBER_45 = 45;

    static WinningNumbers numberListToWinningNumbers(List<Integer> list, int bonusNumber) {
        List<LottoNumber> lottoNumberList = list.stream()
            .map(number -> LottoNumber.from(number))
            .collect(Collectors.toList());
        Lotto lotto = Lotto.from(lottoNumberList);
        LottoNumber bonusLottoNumber = LottoNumber.from(bonusNumber);

        return WinningNumbers.from(lotto, bonusLottoNumber);
    }

    static Stream<Arguments> generateListWithIntTypeIncludeLottoNumber() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
            Arguments.of(Arrays.asList(2, 1, 3, 4, 5, 6)),
            Arguments.of(Arrays.asList(2, 3, 1, 4, 5, 6)),
            Arguments.of(Arrays.asList(2, 3, 4, 1, 5, 6)),
            Arguments.of(Arrays.asList(2, 3, 4, 5, 1, 6)),
            Arguments.of(Arrays.asList(2, 3, 4, 5, 6, 1))
        );
    }

    @DisplayName(value = "winningNumbers에 포함되는 lottoNumber가 주어질 때, isWinningNumbersContain 의 반환값은 참이다.")
    @ParameterizedTest
    @MethodSource("generateListWithIntTypeIncludeLottoNumber")
    void GivenLottoNumberInListWithIntType_WhenIsWinningNumbersContain_ThenTrue(
        List<Integer> winningNumbersInput) {
        WinningNumbers winningNumbers = numberListToWinningNumbers(winningNumbersInput,
            DEFAULT_BONUS_NUMBER_45);
        LottoNumber lottoNumber = LottoNumber.from(1);

        assertThat(winningNumbers.isWinningNumbersContain(lottoNumber))
            .isEqualTo(true);
    }

    static Stream<Arguments> generateListWithIntTypeExcludeLottoNumber() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
            Arguments.of(Arrays.asList(10, 20, 30, 40, 41, 42))
        );
    }

    @DisplayName(value = "winningNumbers에 포함되지 않는 lottoNumber가 주어질 때, isWinningNumbersContain 의 반환값은 거짓이다.")
    @ParameterizedTest
    @MethodSource("generateListWithIntTypeExcludeLottoNumber")
    void GivenLottoNumberNotInListWithIntType_WhenIsWinningNumbersContain_ThenFalse(
        List<Integer> winningNumbersInput) {
        WinningNumbers winningNumbers = numberListToWinningNumbers(winningNumbersInput,
            DEFAULT_BONUS_NUMBER_45);
        LottoNumber lottoNumber = LottoNumber.from(45);

        assertThat(winningNumbers.isWinningNumbersContain(lottoNumber))
            .isEqualTo(false);
    }

    @DisplayName(value = "동일한 두 보너스 넘버가 인자로 주어질 때, isWinningNumbersContain 의 반환값은 참이다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 45})
    void GivenTwoSameBonusLottoNumberWithIntType_WhenIsBonusNumberContain_ThenTrue(
        int bonusNumber) {
        WinningNumbers winningNumbers = numberListToWinningNumbers(DEFAULT_WINNING_NUMBER_LIST,
            bonusNumber);
        LottoNumber bonusLottoNumber = LottoNumber.from(bonusNumber);

        assertThat(winningNumbers.isBonusNumberEqualTo(bonusLottoNumber))
            .isEqualTo(true);
    }
}
