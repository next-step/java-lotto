package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberTest {

    @DisplayName("당첨번호 6개의 숫자로 이루어짐")
    @ParameterizedTest
    @MethodSource("provideWinningNumbers")
    void winningNumber_숫자6개구성(String[] input, String[] expected) {
        WinningNumber winningNumberInput = WinningNumber.of(input);
        WinningNumber winningNumberExpeced = WinningNumber.of(expected);
        assertThat(winningNumberInput).isEqualTo(winningNumberExpeced);
    }

    private static Stream<Arguments> provideWinningNumbers() {
        return Stream.of(
                Arguments.of(new String[]{"1", "3", "5", "7", "9", "11"}, new String[]{"1", "3", "5", "7", "9", "11"}),
                Arguments.of(new String[]{"5", "10", "13", "17", "29", "31"}, new String[]{"5", "10", "13", "17", "29", "31"}),
                Arguments.of(new String[]{"21", "33", "34", "37", "40", "45"}, new String[]{"21", "33", "34", "37", "40", "45"})
        );
    }
}
