package calculator;

import static org.assertj.core.api.Assertions.assertThat;
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
    void additionTest(String formula, int result) {
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
}
