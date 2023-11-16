package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.AddExpression;
import calculator.domain.Expression;
import calculator.domain.VariableExpression;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AddExpressionTest {

    @DisplayName("덧셈을 합니다.")
    @MethodSource
    @ParameterizedTest(name = "[{index}] {0} + {1} = {2}")
    void plusCalculate(VariableExpression left, VariableExpression right, VariableExpression result){
        AddExpression addExpression = new AddExpression(left, right);
        assertThat(addExpression.calculate().value()).isEqualTo(result.value());
    }


    private static Stream<Arguments> plusCalculate(){
        return Stream.of(
            Arguments.of(VariableExpression.of("10"), VariableExpression.of("20"), VariableExpression.of("30")),
            Arguments.of(VariableExpression.of("-5"), VariableExpression.of("5"), VariableExpression.of("0")),
            Arguments.of(VariableExpression.of("100"), VariableExpression.of("-50"), VariableExpression.of("50")),
            Arguments.of(VariableExpression.of("0"), VariableExpression.of("0"), VariableExpression.of("0")),
            Arguments.of(VariableExpression.of("123456789"), VariableExpression.of("-123456789"), VariableExpression.of("0"))
        );
    }
}
