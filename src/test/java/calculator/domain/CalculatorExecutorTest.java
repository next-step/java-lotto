package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorExecutorTest {

    @ParameterizedTest(name = "연산식 : {0}, 결과 : {1}")
    @MethodSource("splitExpression")
    @DisplayName("입력값의 순서에 따라 계산하여 결과를 반환한다.")
    void calculate2(String expression, int result) {
        int actual = CalculatorExecutor.calculate(Splitter.splitNumbers(expression), Splitter.splitOperators(expression));

        assertThat(actual).isEqualTo(result);
    }

    static Stream<Arguments> splitExpression() {
        return Stream.of(
                Arguments.arguments("2 * 3 / 2", 3),
                Arguments.arguments("5 + 3 - 3", 5),
                Arguments.arguments("5 * 3 - 2 / 2", 6)
        );
    }
}