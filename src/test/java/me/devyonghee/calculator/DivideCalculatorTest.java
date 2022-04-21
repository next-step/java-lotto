package me.devyonghee.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("나누기 계산기")
class DivideCalculatorTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> DivideCalculator.of(() -> Number.ONE, Number.ONE));
    }

    @Test
    @DisplayName("계산기와 계산할 숫자는 필수")
    void instance_nullArgument_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> DivideCalculator.of(null, Number.ONE));
        assertThatIllegalArgumentException().isThrownBy(() -> DivideCalculator.of(() -> Number.ONE, null));
    }

    @Test
    @DisplayName("나누는 값이 0이면 안됨")
    void instance_zeroValue_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> DivideCalculator.of(() -> Number.ONE, Number.ZERO))
                .withMessage("number to divide cannot be zero");
    }

    @ParameterizedTest(name = "[{index}] {0} 값을 {1} 로 나누면 {2}")
    @DisplayName("계산")
    @MethodSource
    void calculatedNumber(Number dividendNumber, Number divisorNumber, Number expected) {
        assertThat(DivideCalculator.of(() -> dividendNumber, divisorNumber).calculatedNumber()).isEqualTo(expected);
    }

    public static Stream<Arguments> calculatedNumber() {
        return Stream.of(
                Arguments.of(Number.ZERO, Number.ONE, Number.ZERO),
                Arguments.of(Number.ONE, Number.ONE, Number.ONE)
        );
    }
}
