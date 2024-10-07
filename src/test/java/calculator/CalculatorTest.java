package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorTest {

    @DisplayName("사칙 연산이 잘 수행되는지")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void arithmeticOperationTest(String formula, int result) {
        assertThat(Calculator.calculate(formula)).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult() {
        return Stream.of(
                arguments("1 + 2", 3),
                arguments("5 - 3", 2),
                arguments("6 * 4", 24),
                arguments("8 / 2", 4)
        );
    }

    @DisplayName("0으로 나누었을 때 IllegalArgumentException 예외가 잘 반환되는지")
    @Test
    void divisionWithZeroTest() {
        assertThatThrownBy(() -> Calculator.calculate("5 / 0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙 연산자가 아닌 문자열이 주어진 경우 IllegalArgumentException 예외가 잘 반환되는지")
    @Test
    void calculateTestWithNoneArithmeticOperator() {
        assertThatThrownBy(() -> Calculator.calculate("5 @ 2"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
