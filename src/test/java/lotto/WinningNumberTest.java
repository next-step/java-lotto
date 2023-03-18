package lotto;

import lotto.domain.WinningNumbers;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class WinningNumberTest {

    @DisplayName("당첨번호와 추출한 숫자 중 일치하는 갯수를 구한다.")
    @Test
    void matchWinningNumber() {
        WinningNumbers winningNumbers = new WinningNumbers(7,1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        int matchCount = winningNumbers.matchWinningCount(lotto);
        Assertions.assertThat(matchCount).isEqualTo(6);
    }

    @DisplayName("보너스번호가 추출한 숫자 중 일치하는지 확인한다.")
    @ParameterizedTest
    @MethodSource("generateArgumentsSet")
    void isMatchBonusNumber(boolean expectResult, List<Integer> numbers) {
        WinningNumbers winningNumbers = new WinningNumbers(7, 1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers.stream().mapToInt(i -> i).toArray());

        Assertions.assertThat(winningNumbers.isMatchBonus(lotto)).isEqualTo(expectResult);
    }

    @DisplayName("보너스번호는 당첨번호와 중복될 수 없다.")
    @Test
    void isContainWinningNumber() {
        Assertions.assertThatThrownBy(() -> new WinningNumbers(6, 1, 2, 3, 4, 5, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> generateArgumentsSet() {
        return Stream.of(
                Arguments.arguments(false, List.of(1, 2, 3, 4, 5, 6)),
                Arguments.arguments(true, List.of(1, 2, 3, 4, 5, 7))
        );
    }

}
