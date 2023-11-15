package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @ParameterizedTest(name = "숫자 : {0}, 연산자 : {1}, 결과 : {2}")
    @MethodSource("splitExpression")
    @DisplayName("입력값의 순서에 따라 계산하여 결과를 반환한다.")
    void calculate(List<Integer> numbers, List<Operator> operators, int expected) {
        int actual = Calculator.calculate(numbers, operators);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> splitExpression() {
        return Stream.of(
                Arguments.arguments(Splitter.splitNumbers("2 * 3 / 2"), Splitter.splitOperators("2 * 3 / 2"), 3),
                Arguments.arguments(Splitter.splitNumbers("5 + 3 - 3"), Splitter.splitOperators("5 + 3 - 3"), 5),
                Arguments.arguments(Splitter.splitNumbers("5 * 3 - 2 / 2"), Splitter.splitOperators("5 * 3 - 2 / 2"), 6)
        );
    }
}