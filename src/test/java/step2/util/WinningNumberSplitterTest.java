package step2.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.model.LottoRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberSplitterTest {

    @DisplayName("split() 메서드는 콤마를 구분자로 분할하여 숫자 리스트를 반환한다")
    @MethodSource("provideWinningNumberForSplit")
    @ParameterizedTest(name = "''{0}''을 입력하면 ''{1}''을 반환한다")
    void split_ValidNumber_WinningNumbers(String winningNumber, List<Integer> expected) {
        List<Integer> winningNumbers = WinningNumberSplitter.split(winningNumber);

        assertThat(winningNumbers).isEqualTo(expected);
    }

    private static Stream<Arguments> provideWinningNumberForSplit() {
        return Stream.of(
                Arguments.of(",", new ArrayList<Integer>()),
                Arguments.of("1", Stream.of(1).collect(Collectors.toList())),
                Arguments.of("1,2,3,4,", Stream.of(1,2,3,4).collect(Collectors.toList())),
                Arguments.of("1,2,3,4", Stream.of(1,2,3,4).collect(Collectors.toList()))
        );
    }

    @DisplayName("split() 메서드는 숫자와 콤마가 아닌 다른 문자가 있으면 예외를 발생한다")
    @ValueSource(strings = {"a,b,c", "1,b,c'"})
    @ParameterizedTest
    void split_InvalidNumber_WinningNumbers(String winningNumber) {
        assertThatThrownBy(() -> {
            WinningNumberSplitter.split(winningNumber);
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
