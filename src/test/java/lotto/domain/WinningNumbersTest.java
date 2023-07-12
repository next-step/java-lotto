package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class WinningNumbersTest {

    @Test
    @DisplayName("당첨 번호가 주어지면 객체를 생성한다.")
    void create() {

        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Assertions.assertThatNoException()
                .isThrownBy(() -> new WinningNumbers(lottoNumbers, bonusNumber));
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복이 있다면 예외를 던진다.")
    void validateDuplicatedBonus() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        Assertions.assertThatThrownBy(() -> new WinningNumbers(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideLottoResults")
    @DisplayName("로또와 당첨 번호를 비교하여 등수를 반환한다.")
    void match(Lotto lotto, LottoRank lottoRank) {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        Assertions.assertThat(winningNumbers.match(lotto)).isEqualTo(lottoRank);
    }

    private static Stream<Arguments> provideLottoResults() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoRank.FIRST),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), LottoRank.SECOND),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 9)), LottoRank.THIRD),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 8, 9)), LottoRank.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 10, 8, 9)), LottoRank.FIFTH),
                Arguments.of(new Lotto(List.of(1, 2, 14, 10, 8, 9)), LottoRank.NONE)
        );
    }
}
