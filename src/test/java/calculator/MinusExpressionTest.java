package calculator;

import calculator.domain.VariableExpression;
import calculator.domain.MinusExpression;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MinusExpressionTest {

    @DisplayName("뺄셈을 합니다.")
    @MethodSource
    @ParameterizedTest(name = "[{index}] {0} - {1} = {2}")
    void minusCalculate(VariableExpression left, VariableExpression right, VariableExpression result){
        MinusExpression minusExpression = new MinusExpression(left, right);
        Assertions.assertThat(minusExpression.calculate().value()).isEqualTo(result.value());
    }

    private static Stream<Arguments> minusCalculate(){
        return Stream.of(
            Arguments.of(VariableExpression.of("50"), VariableExpression.of("23"), VariableExpression.of("27")),
            Arguments.of(VariableExpression.of("7"), VariableExpression.of("3"), VariableExpression.of("4")),
            Arguments.of(VariableExpression.of("10"), VariableExpression.of("20"), VariableExpression.of("-10")),
            Arguments.of(VariableExpression.of("-5"), VariableExpression.of("5"), VariableExpression.of("-10")),
            Arguments.of(VariableExpression.of("100"), VariableExpression.of("-50"), VariableExpression.of("150")),
            Arguments.of(VariableExpression.of("0"), VariableExpression.of("0"), VariableExpression.of("0")),
            Arguments.of(VariableExpression.of("123456789"), VariableExpression.of("-123456789"), VariableExpression.of("246913578"))
        );
    }
}
