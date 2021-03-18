package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    static Stream<Arguments> generateTestCase() {
        return Stream.of(
            Arguments.of("1,2,3", 6),
            Arguments.of("1:2:3", 6),
            Arguments.of("1,2:3", 6),
            Arguments.of("//;\n1;2;3", 6),
            Arguments.of("", 0),
            Arguments.of(null, 0),
            Arguments.of("3", 3)
        );
    }

    @ParameterizedTest(name = "문자열 {0} 에서 숫자를 분리한 다음, 그 합을 반환한다.")
    @MethodSource("generateTestCase")
    void sumFromExpression(String expression, int expected) {
        assertThat(calculator.sum(expression)).isEqualTo(expected);
    }

    @Test
    @DisplayName("음수가 포함되어 있으면 예외를 던진다.")
    void throwExceptionIfInputContainsNegativeInteger() {
        assertThatThrownBy(() -> calculator.sum("-1")).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("정수가 아닌 문자가 포함되어 있으면 예외를 던진다.")
    void throwExceptionIfInputContainsStringNotNumber() {
        assertThatThrownBy(() -> calculator.sum("a")).isInstanceOf(RuntimeException.class);
    }
}
