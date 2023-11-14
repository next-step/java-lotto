import static org.assertj.core.api.Assertions.assertThat;

import java.beans.Expression;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.assertj.core.internal.bytebuddy.asm.Advice.Argument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorTest {

    private static final VariableExpression VARIABLE_ONE = new VariableExpression('1');
    private static final VariableExpression VARIABLE_TWO = new VariableExpression('2');
    @DisplayName("기호를 만나면 알맞은 Expression을 반환한다.")
    @ParameterizedTest(name = " \"{0}\"은 \"{1}\"타입")
    @MethodSource
    void someMarkMustReturnExpressionType(String postfixString, CalculatorExpression expectedType){
        CalculatorExpression expression = Calculator.calculate(postfixString);
        assertThat(expression).isInstanceOf(expectedType.getClass());
        assertThat(expression.calculate()).isEqualTo(expectedType.calculate());
    }

    static Stream<Arguments> someMarkMustReturnExpressionType(){
        return Stream.of(
            Arguments.arguments("12+", new AddExpression(VARIABLE_ONE,VARIABLE_TWO)),
            Arguments.arguments("12-", new MinusExpression(VARIABLE_ONE,VARIABLE_TWO)),
            Arguments.arguments("12*", new MultiplicationExpression(VARIABLE_ONE,VARIABLE_TWO)),
            Arguments.arguments("12/", new DivideExpression(VARIABLE_ONE,VARIABLE_TWO))
        );
    }

}
