package lotto.model;

import lotto.LottoGenerator;
import lotto.LottoNumber;
import lotto.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningPriceTest {
    @ParameterizedTest
    @MethodSource("provideTestArguments")
    @DisplayName("of 메소드로 WinningPrice 객체를 생성한다")
    void 테스트_of_WinningPrice_객체를_생성한다(int input, boolean isBonusMatch, WinningPrice expected) {
        // given
        assertThat(WinningPrice.of(input, isBonusMatch)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTestArguments() { // argument source method
        return Stream.of(
                Arguments.of(2, false, WinningPrice.NOTWIN),
                Arguments.of(3, false, WinningPrice.FIFTH),
                Arguments.of(4, false, WinningPrice.FORTH),
                Arguments.of(5, false, WinningPrice.THIRD),
                Arguments.of(5, true, WinningPrice.SECOND),
                Arguments.of(6, false, WinningPrice.FIRST),
                Arguments.of(7, false, WinningPrice.NOTWIN)
        );
    }
}