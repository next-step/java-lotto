package step2.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberSplitterTest {

    @DisplayName("콤마를 구분자로 분할하여 숫자 리스트를 반환")
    @MethodSource("provideNumberForSplit")
    @ParameterizedTest(name = "입력 - ''{0}'', 반환 - ''{1}''")
    void split(String winningNumber, List<Integer> expected) {
        List<Integer> winningNumbers = LottoNumberSplitter.split(winningNumber);

        assertThat(winningNumbers).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNumberForSplit() {
        return Stream.of(
                Arguments.of(",", new ArrayList<Integer>()),
                Arguments.of("1", Stream.of(1).collect(Collectors.toList())),
                Arguments.of("1,2,3,4,", Stream.of(1, 2, 3, 4).collect(Collectors.toList())),
                Arguments.of("1,2,3,4", Stream.of(1, 2, 3, 4).collect(Collectors.toList()))
        );
    }

    @DisplayName("숫자와 콤마가 아닌 다른 문자가 있으면 예외 발생")
    @ValueSource(strings = {"a,b,c", "1,b,c'"})
    @ParameterizedTest
    void splitExceptionThrown(String winningNumber) {
        assertThatThrownBy(() -> {
            LottoNumberSplitter.split(winningNumber);
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
