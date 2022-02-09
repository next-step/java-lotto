package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumbersTest {

    static Stream<Arguments> generateValidWinningNumbersInput() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
            Arguments.of(Arrays.asList(10, 11, 12, 13, 14, 15)),
            Arguments.of(Arrays.asList(10, 20, 30, 40, 9, 45))
        );
    }

    @DisplayName(value = "정수 리스트의 크기가 6이면, winningNumbers 의 크기가 6")
    @ParameterizedTest
    @MethodSource("generateValidWinningNumbersInput")
    void GivenListWithIntType_WhenListSizeis6_ThenWinningNumbersSize6(
        List<Integer> winningNumbersInput) {
        final int winningNumbersSize = WinningNumbers.from(winningNumbersInput).getWinningNumbers().size();

        assertThat(winningNumbersSize)
            .isEqualTo(6);
    }

    static Stream<Arguments> generateInvalidSizeWinningNumbersInput() {
        return Stream.of(
            Arguments.of(Arrays.asList()),
            Arguments.of(Arrays.asList(1)),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @DisplayName(value = "정수 리스트의 크기가 6이 아니면, IllegalArgumentException.")
    @ParameterizedTest
    @MethodSource("generateInvalidSizeWinningNumbersInput")
    void GivenListWithIntType_WhenListSizeNot6_ThenIllegalArgumentException(
        List<Integer> winningNumbersInput) {
        assertThatThrownBy(() -> WinningNumbers.from(winningNumbersInput))
            .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generateInvalidRangeWinningNumbersInput() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 46)),
            Arguments.of(Arrays.asList(0, 2, 3, 4, 5, 6)),
            Arguments.of(Arrays.asList(1, 2, 46, 4, 5, 6)),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 100)),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 1000))
        );
    }

    @DisplayName(value = "정수 리스트의 범위가 당첨 번호 범위내에 있지 않으면, IllegalArgumentException.")
    @ParameterizedTest
    @MethodSource("generateInvalidRangeWinningNumbersInput")
    void GivenListWithIntType_WhenWinningNumberIsNotInRange_ThenIllegalArgumentException(
        List<Integer> winningNumbersInput) {
        assertThatThrownBy(() -> WinningNumbers.from(winningNumbersInput))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
