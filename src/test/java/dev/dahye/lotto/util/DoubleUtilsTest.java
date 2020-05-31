package dev.dahye.lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("DoubleUtils 테스트")
class DoubleUtilsTest {
    @ParameterizedTest(name = "input = {0}, expected = {1}")
    @MethodSource("doubleValues")
    @DisplayName("소수점 두자리까지 노출")
    void double_utils(double input, double expected) {
        assertThat(DoubleUtils.parseDoubleSecondDigit(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> doubleValues() {
        return Stream.of(
                arguments(1, 1),
                arguments(0.1, 0.1),
                arguments(0.12, 0.12),
                arguments(0.123, 0.12),
                arguments(0.1234, 0.12)
        );
    }
}