package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환")
    @ParameterizedTest
    @MethodSource("source_parse_validParameters_shouldSucceed")
    public void parse_validParameters_shouldSucceed(String input, int expected) {
        StringAddCalculator calculator = new StringAddCalculator();
        assertThat(calculator.sum(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> source_parse_validParameters_shouldSucceed() {
        return Stream.of(
                Arguments.of("0", 0),
                Arguments.of("1,2", 3),
                Arguments.of("1,2,3", 6),
                Arguments.of("1,2:3", 6));
    }

    @DisplayName("커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @MethodSource("source_parse_customDelimiter_shouldSucceed")
    public void parse_customDelimiter_shouldSucceed(String input, int expected) {
        StringAddCalculator calculator = new StringAddCalculator();
        assertThat(calculator.sum(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> source_parse_customDelimiter_shouldSucceed() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", 6));
    }
}
