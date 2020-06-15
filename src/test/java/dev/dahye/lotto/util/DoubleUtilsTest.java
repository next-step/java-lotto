package dev.dahye.lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("DoubleUtils 테스트")
class DoubleUtilsTest {
    @ParameterizedTest(name = "input = {0}, expected = {1}")
    @MethodSource("doubleValues")
    @DisplayName("소수점 둘째 자리 이후 반올림")
    void double_utils(double input, BigDecimal expected) {
        assertThat(DoubleUtils.parseDoubleSecondDigit(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> doubleValues() {
        return Stream.of(
                arguments(1, new BigDecimal("1.00")),
                arguments(0.1, new BigDecimal("0.10")),
                arguments(0.12, new BigDecimal("0.12")),
                arguments(0.126, new BigDecimal("0.13")),
                arguments(0.1256, new BigDecimal("0.13"))
        );
    }
}