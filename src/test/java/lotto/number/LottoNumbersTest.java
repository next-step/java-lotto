package lotto.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("로또 숫자 리스트는")
class LottoNumbersTest {

    private static Stream<Arguments> provideLottoNumbersAndWinningNumbersCounts() {
        return Stream.of(
                Arguments.of(new LottoNumbers(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(new LottoNumbers(1, 2, 3, 4, 5, 7), 5),
                Arguments.of(new LottoNumbers(1, 2, 3, 4, 8, 7), 4),
                Arguments.of(new LottoNumbers(1, 2, 3, 9, 8, 7), 3),
                Arguments.of(new LottoNumbers(12, 11, 10, 9, 8, 7), 0)
        );
    }

    @DisplayName("길이가 6이 아닐 경우 에러 발생")
    @Test
    void lottoNumbersAboveOrUnder6ThrowsError() {
        assertThatThrownBy(() -> new LottoNumbers(1, 2, 3, 4, 5)).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("로또 숫자는 6개입니다.");
    }

    @DisplayName("길이가 6일 경우 정상")
    @Test
    void lottoNumbersLengthMustBe6() {
        assertDoesNotThrow(() -> new LottoNumbers(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨번호가 1,2,3,4,5,6일 때 ")
    @ParameterizedTest(name = "{1}개 당첨")
    @MethodSource("provideLottoNumbersAndWinningNumbersCounts")
    void tellsHowManyWinningNumbersAreIncluded(LottoNumbers lottoNumbers, int winningNumberCounts) {
        assertThat(lottoNumbers.matchOf(new WinningNumbers(1, 2, 3, 4, 5, 6))).isEqualTo(winningNumberCounts);
    }
}
