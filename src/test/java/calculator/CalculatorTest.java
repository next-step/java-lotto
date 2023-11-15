package calculator;

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

//    private static final calculator.domain.VariableExpression VARIABLE_ONE = new calculator.domain.VariableExpression('1');
//    private static final calculator.domain.VariableExpression VARIABLE_TWO = new calculator.domain.VariableExpression('2');
//    @DisplayName("기호를 만나면 알맞은 Expression을 반환한다.")
//    @ParameterizedTest(name = " \"{0}\"은 \"{1}\"타입")
//    @MethodSource
//    void someMarkMustReturnExpressionType(String postfixString, calculator.domain.CalculatorExpression expectedType){
//        calculator.domain.CalculatorExpression expression = calculator.domain.Calculator.calculate(postfixString);
//        assertThat(expression).isInstanceOf(expectedType.getClass());
//        assertThat(expression.calculate()).isEqualTo(expectedType.calculate());
//    }
//
//    static Stream<Arguments> someMarkMustReturnExpressionType(){
//        return Stream.of(
//            Arguments.arguments("12+", new domain.AddExpression(VARIABLE_ONE,VARIABLE_TWO)),
//            Arguments.arguments("12-", new domain.MinusExpression(VARIABLE_ONE,VARIABLE_TWO)),
//            Arguments.arguments("12*", new domain.MultiplicationExpression(VARIABLE_ONE,VARIABLE_TWO)),
//            Arguments.arguments("12/", new domain.DivideExpression(VARIABLE_ONE,VARIABLE_TWO))
//        );
//    }

}
