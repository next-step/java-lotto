package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTypeTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void 숫자일치_3개_미만(int matchCount) {
        assertThat(WinningType.of(matchCount)).isEqualTo(WinningType.NOT_WINNING);
    }

    @ParameterizedTest
    @MethodSource("provideIntsWinningType")
    void 숫자일치_3개_이상(int matchCount, WinningType winningType) {
        assertThat(WinningType.of(matchCount)).isEqualTo(winningType);
    }

    private static Stream<Arguments> provideIntsWinningType() {
        return Stream.of(
                Arguments.of(3, WinningType.FOURTH_PLACE),
                Arguments.of(4, WinningType.THIRD_PLACE),
                Arguments.of(5, WinningType.SECOND_PLACE),
                Arguments.of(6, WinningType.FIRST_PLACE)
        );
    }
}
