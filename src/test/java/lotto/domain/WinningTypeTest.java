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
        assertThat(WinningType.of(matchCount, false)).isEqualTo(WinningType.NOT_WINNING);
    }

    @ParameterizedTest
    @MethodSource("provideIntsWinningType")
    void 숫자일치_3개_이상(int matchCount, boolean matchBonus, WinningType winningType) {
        assertThat(WinningType.of(matchCount, matchBonus)).isEqualTo(winningType);
    }

    private static Stream<Arguments> provideIntsWinningType() {
        return Stream.of(
                Arguments.of(3, false, WinningType.FIVE_PLACE),
                Arguments.of(4, false, WinningType.FOURTH_PLACE),
                Arguments.of(5, false, WinningType.THIRD_PLACE),
                Arguments.of(5, true, WinningType.SECOND_PLACE),
                Arguments.of(6, false, WinningType.FIRST_PLACE)
        );
    }
}
