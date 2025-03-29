package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningLottoTest {

    @ParameterizedTest(name = "당첨 번호를 6개 입력하지 않으면 예외를 던진다.")
    @MethodSource("winningNumbersWithInvalidLength")
    void sizeOfWinningNumberTest(List<Integer> input) {
        assertThatThrownBy(() -> WinningLotto.of(input, 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> winningNumbersWithInvalidLength() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5)),      // 5개
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7)) // 7개
        );
    }

    @Test
    @DisplayName("당첨번호에 중복되는 숫자를 입력하면 예외를 던진다.")
    void redundantWinningNumbersTest() {
        List<Integer> input = List.of(1,2,3,4,5,5);
        assertThatThrownBy(() -> WinningLotto.of(input, 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호에 당첨번호와 중복되는 숫자를 입력하면 예외를 던진다.")
    void redundantBonusNumbersTest() {
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 6;
        assertThatThrownBy(() -> WinningLotto.of(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
