package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.MultiplicationExpression;
import calculator.domain.VariableExpression;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MultiplicationExpressionTest {


    @DisplayName("곱셈을 합니다.")
    @MethodSource
    @ParameterizedTest(name = "[{index}] {0} * {1} = {2}")
    void multiplicationCalculate(VariableExpression left, VariableExpression right, VariableExpression result) {
        MultiplicationExpression multiplicationExpression = new MultiplicationExpression(left, right);
        assertThat(multiplicationExpression.calculate().value()).isEqualTo(result.value());
    }

    private static Stream<Arguments> multiplicationCalculate() {
        return Stream.of(
            Arguments.of(VariableExpression.of("2"), VariableExpression.of("3"), VariableExpression.of("6")),
            Arguments.of(VariableExpression.of("-5"), VariableExpression.of("5"), VariableExpression.of("-25")),
            Arguments.of(VariableExpression.of("10"), VariableExpression.of("-4"), VariableExpression.of("-40")),
            Arguments.of(VariableExpression.of("0"), VariableExpression.of("99"), VariableExpression.of("0")),
            Arguments.of(VariableExpression.of("7"), VariableExpression.of("1"), VariableExpression.of("7")),
            Arguments.of(VariableExpression.of("11"), VariableExpression.of("11"), VariableExpression.of("121")),
            Arguments.of(VariableExpression.of("12"), VariableExpression.of("12"), VariableExpression.of("144")),
            Arguments.of(VariableExpression.of("123"), VariableExpression.of("321"), VariableExpression.of("39483")),
            Arguments.of(VariableExpression.of("-3"), VariableExpression.of("-4"), VariableExpression.of("12")),
            Arguments.of(VariableExpression.of("111"), VariableExpression.of("-2"), VariableExpression.of("-222"))
        );
    }

}
