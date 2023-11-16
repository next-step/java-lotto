package calculator;

import calculator.domain.Variable;
import calculator.domain.MinusExpression;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MinusExpressionTest {

    @DisplayName("뺄셈을 합니다.")
    @MethodSource
    @ParameterizedTest(name = "[{index}] {0} - {1} = {2}")
    void minusCalculate(Variable left, Variable right, Variable result){
        MinusExpression minusExpression = new MinusExpression(left, right);
        Assertions.assertThat(minusExpression.calculate().value()).isEqualTo(result.value());
    }

    private static Stream<Arguments> minusCalculate(){
        return Stream.of(
            Arguments.of(Variable.of("50"), Variable.of("23"), Variable.of("27")),
            Arguments.of(Variable.of("7"), Variable.of("3"), Variable.of("4")),
            Arguments.of(Variable.of("10"), Variable.of("20"), Variable.of("-10")),
            Arguments.of(Variable.of("-5"), Variable.of("5"), Variable.of("-10")),
            Arguments.of(Variable.of("100"), Variable.of("-50"), Variable.of("150")),
            Arguments.of(Variable.of("0"), Variable.of("0"), Variable.of("0")),
            Arguments.of(Variable.of("123456789"), Variable.of("-123456789"), Variable.of("246913578"))
        );
    }
}
