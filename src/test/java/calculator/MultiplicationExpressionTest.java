package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.MultiplicationExpression;
import calculator.domain.Variable;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MultiplicationExpressionTest {


    @DisplayName("곱셈을 합니다.")
    @MethodSource
    @ParameterizedTest(name = "[{index}] {0} * {1} = {2}")
    void multiplicationCalculate(Variable left, Variable right, Variable result) {
        MultiplicationExpression multiplicationExpression = new MultiplicationExpression(left, right);
        assertThat(multiplicationExpression.calculate().value()).isEqualTo(result.value());
    }

    private static Stream<Arguments> multiplicationCalculate() {
        return Stream.of(
            Arguments.of(Variable.of("2"), Variable.of("3"), Variable.of("6")),
            Arguments.of(Variable.of("-5"), Variable.of("5"), Variable.of("-25")),
            Arguments.of(Variable.of("10"), Variable.of("-4"), Variable.of("-40")),
            Arguments.of(Variable.of("0"), Variable.of("99"), Variable.of("0")),
            Arguments.of(Variable.of("7"), Variable.of("1"), Variable.of("7")),
            Arguments.of(Variable.of("11"), Variable.of("11"), Variable.of("121")),
            Arguments.of(Variable.of("12"), Variable.of("12"), Variable.of("144")),
            Arguments.of(Variable.of("123"), Variable.of("321"), Variable.of("39483")),
            Arguments.of(Variable.of("-3"), Variable.of("-4"), Variable.of("12")),
            Arguments.of(Variable.of("111"), Variable.of("-2"), Variable.of("-222"))
        );
    }

}
