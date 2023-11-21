package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.AddExpression;
import calculator.domain.Variable;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AddExpressionTest {

    @DisplayName("덧셈을 합니다.")
    @MethodSource
    @ParameterizedTest(name = "[{index}] {0} + {1} = {2}")
    void plusCalculate(Variable left, Variable right, Variable result){
        AddExpression addExpression = new AddExpression(left, right);
        assertThat(addExpression.calculate().value()).isEqualTo(result.value());
    }


    private static Stream<Arguments> plusCalculate(){
        return Stream.of(
            Arguments.of(Variable.of("10"), Variable.of("20"), Variable.of("30")),
            Arguments.of(Variable.of("-5"), Variable.of("5"), Variable.of("0")),
            Arguments.of(Variable.of("100"), Variable.of("-50"), Variable.of("50")),
            Arguments.of(Variable.of("0"), Variable.of("0"), Variable.of("0")),
            Arguments.of(Variable.of("123456789"), Variable.of("-123456789"), Variable.of("0"))
        );
    }
}
