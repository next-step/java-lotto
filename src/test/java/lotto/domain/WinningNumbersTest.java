package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    private static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @DisplayName("당첨 번호가 6개가 아닐 경우 예외 발생")
    @ParameterizedTest
    @MethodSource("provideNumbers")
    void hasNotSixNumbersTest(List<Integer> numbers) {
        assertThatThrownBy(() -> new WinningNumbers(List.copyOf(numbers)))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 중복될 경우 예외 발생")
    @Test
    void hasNotUniqueNumbersTest() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1~45 사이의 숫자가 아닌 경우 예외 발생")
    @Test
    void containsNotLottoNumberTest() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(0, 1, 2, 3, 4, 5)))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

}