package lotto.domain;

import lotto.domain.enums.Rank;
import lotto.exception.LottoException;
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
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("당첨번호와 로또번호, 보너스매치를 조회하여 RANK 테스트")
    @ParameterizedTest
    @MethodSource("provideLottos")
    void getLottoMatchCount(int[] input, int bonusNumber, Rank expected) {
        String winningNumbers = "1, 3, 5, 7, 9, 11";
        WinningNumber winningNumber = WinningNumber.of(winningNumbers, bonusNumber);

        Set<LottoNumber> lottoSet = new TreeSet<>(Arrays.stream(input)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
        Lotto lotto = Lotto.of(lottoSet);

        assertThat(winningNumber.rankMatch(lotto)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottos() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 7, 9, 11}, 10, Rank.FIRST),
                Arguments.of(new int[]{1, 3, 5, 7, 9, 12}, 12, Rank.SECOND),
                Arguments.of(new int[]{1, 3, 5, 7, 9, 45}, 12, Rank.THIRD),
                Arguments.of(new int[]{1, 3, 5, 7, 10, 43}, 15, Rank.FOURTH),
                Arguments.of(new int[]{1, 3, 5, 40, 41, 45}, 12, Rank.FIFTH),
                Arguments.of(new int[]{1, 3, 2, 40, 41, 45}, 12, Rank.MISS)
        );
    }

    @DisplayName("당첨번호에 보너스 번호가 올 경우 에러")
    @ParameterizedTest
    @MethodSource("providewinningNumberContainBonusNumber")
    void winningNumberContainBonusNumber_에러테스트(String lottoNumber, int bonusNumber) {
        assertThatThrownBy(() -> {
            WinningNumber.of(lottoNumber, bonusNumber);
        }).isInstanceOf(LottoException.class)
                .hasMessage("당첨번호에 보너스번호가 올 수 없습니다.");

    }

    private static Stream<Arguments> providewinningNumberContainBonusNumber() {
        return Stream.of(
                Arguments.of("1, 3, 5, 7, 9, 11", 9),
                Arguments.of("5, 10, 13, 17, 29, 31", 29),
                Arguments.of("21, 33, 34, 37, 40, 45", 40)
        );
    }
}
