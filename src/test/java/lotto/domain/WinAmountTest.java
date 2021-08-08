package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinAmountTest {
    @ParameterizedTest
    @MethodSource("provideParameters")
    void valueOfMatchCount(int matchCount, boolean isMatchBonus, WinAmount winAmount) {
        assertThat(WinAmount.valueOfMatchCount(matchCount, isMatchBonus)).isEqualTo(winAmount);
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("6", true, WinAmount.FIRST),
                Arguments.of("5", true, WinAmount.SECOND),
                Arguments.of("5", false, WinAmount.THIRD),
                Arguments.of("4", true, WinAmount.FOURTH),
                Arguments.of("3", true, WinAmount.FIFTH),
                Arguments.of("2", true, WinAmount.FAIL)
        );
    }
}