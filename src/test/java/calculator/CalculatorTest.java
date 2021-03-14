package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void init() {
        Parser parser = new Parser();
        calculator = new Calculator(parser);
    }

    static Stream<Arguments> generateTestCase() {
        return Stream.of(
            Arguments.of("1,2,3", 6),
            Arguments.of("1:2:3", 6),
            Arguments.of("1,2:3", 6),
            Arguments.of("//;\n1;2;3", 6),
            Arguments.of("", 0),
            Arguments.of(null, 0)
        );
    }

    @ParameterizedTest(name = "문자열 {0} 에서 숫자를 분리한 다음, 그 합을 반환한다.")
    @MethodSource("generateTestCase")
    void sumFromExpression(String expression, int expected) {
        assertThat(calculator.sum(expression)).isEqualTo(expected);
    }

}
