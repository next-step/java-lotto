package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StringCalculatorTest {

    static Stream<Arguments> parameters() {
        return Stream.of(
                arguments(null, 0),
                arguments("", 0),
                arguments(" ", 0)
        );
    }

    @ParameterizedTest
    @DisplayName("빈 문자열, null이 들어오면 0을 반환")
    @MethodSource("parameters")
    void inputTest(String input, int expected) {
        assertThat(StringCalculator.sum(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자 한 개 덧셈 연산")
    void sumOneNumber() {
        assertAll(
                () -> assertThat(StringCalculator.sum("0")).isEqualTo(0),
                () -> assertThat(StringCalculator.sum("1")).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("숫자 여러 개 덧셈 연산")
    void sumMultiNumbers() {
        assertAll(
                () -> assertThat(StringCalculator.sum("0:1")).isEqualTo(1),
                () -> assertThat(StringCalculator.sum("0,1,2")).isEqualTo(3),
                () -> assertThat(StringCalculator.sum("1,2:3")).isEqualTo(6)
        );
    }

    @Test
    @DisplayName("숫자 여러 개 커스텀 덧셈 연산")
    void sumMultiNumbersWithCustomDelimiter() {
        assertAll(
                () -> assertThat(StringCalculator.sum("//;\n0;1")).isEqualTo(1),
                () -> assertThat(StringCalculator.sum("//&\n0&1&2")).isEqualTo(3)
        );
    }

    @Test
    @DisplayName("음수 덧셈 예외 처리")
    void sumNegative() {
        assertThatThrownBy(
                () -> StringCalculator.sum("-1,0")
        ).isInstanceOf(RuntimeException.class);
    }
}
