package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoNumbersTest {

    @Test
    @DisplayName("보너스 숫자는 로또 당첨 번호와 겹치지 않아야 한다.")
    public void bonusNumberTest() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        new WinningLottoNumbers(List.of(1, 2, 3, 4, 5, 6), 6));
    }

    @DisplayName("당첨 숫자와 구매한 로또의 숫자가 일치하는 수를 반환한다.")
    @ParameterizedTest
    @MethodSource("getResultParameters")
    public void getResultTest(List<Integer> purchasedNumbers, List<Integer> winningNumbers, int expected) {
        assertThat(new WinningLottoNumbers(winningNumbers, 1).matchedCount(Lotto.of(purchasedNumbers)))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> getResultParameters() {
        return Stream.of(
                Arguments.of(List.of(5, 10, 15, 20, 25, 30), List.of(6, 11, 16, 21, 26, 31), 0),
                Arguments.of(List.of(5, 10, 15, 20, 25, 30), List.of(6, 10, 16, 21, 26, 31), 1),
                Arguments.of(List.of(5, 10, 15, 20, 25, 30), List.of(6, 10, 16, 21, 26, 30), 2),
                Arguments.of(List.of(5, 10, 15, 20, 25, 30), List.of(5, 11, 15, 20, 26, 31), 3),
                Arguments.of(List.of(5, 10, 15, 20, 25, 30), List.of(6, 10, 15, 20, 25, 31), 4),
                Arguments.of(List.of(5, 10, 15, 20, 25, 30), List.of(5, 11, 15, 20, 25, 30), 5),
                Arguments.of(List.of(5, 10, 15, 20, 25, 30), List.of(5, 10, 15, 20, 25, 30), 6)
        );
    }
}
