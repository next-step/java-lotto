package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WinningTypeTest {

    @DisplayName("일치하는 숫자 개수에 따라 로또 당첨 타입을 리턴한다.")
    @ParameterizedTest
    @MethodSource("providerTestValueOf")
    void testValueOf(int matchedCount, WinningType expected) {
        WinningType type = WinningType.valueOf(matchedCount);
        Assertions.assertThat(type)
                .isEqualTo(expected);
    }

    static Stream<Arguments> providerTestValueOf(){
        return Stream.of(
                Arguments.of(6, WinningType.FIRST),
                Arguments.of(5, WinningType.THIRD),
                Arguments.of(4, WinningType.FOURTH),
                Arguments.of(3, WinningType.FIFTH),
                Arguments.of(2, WinningType.NONE),
                Arguments.of(1, WinningType.NONE),
                Arguments.of(0, WinningType.NONE)
        );
    }
}