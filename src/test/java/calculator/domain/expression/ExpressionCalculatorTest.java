package calculator.domain.expression;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayDeque;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("연산식 클래스 테스트")
public class ExpressionCalculatorTest {

    @ParameterizedTest(name = "피연산자 3개와 연산자 2개가 주어졌을때 연산결과를 얻을수있다")
    @MethodSource("expressionCases")
    void 다양한_연산수행을_할수있다(String firstOperand, String secondOperand, String thirdOperand,
                        Operator firstOperator, Operator secondOperator, int expectedArithmeticResult) {

        Operands operands = new Operands(new ArrayDeque<>(
                List.of(
                        new Operand(firstOperand),
                        new Operand(secondOperand),
                        new Operand(thirdOperand)
                )
        ));
        Operators operators = new Operators(new ArrayDeque<>(
                List.of(
                        firstOperator,
                        secondOperator
                )
        ));

        int actualResult = ExpressionCalculator.calculateExpression(operands, operators);

        Assertions.assertEquals(expectedArithmeticResult, actualResult);
    }

    private static Stream<Arguments> expressionCases() {
        return Stream.of(
                arguments("2", "3", "4", Operator.ADDITION, Operator.SUBTRACTION, 1),
                arguments("1", "5", "2", Operator.MULTIPLICATION, Operator.ADDITION, 7),
                arguments("10", "5", "2", Operator.DIVISION, Operator.MULTIPLICATION, 4),
                arguments("100", "5", "2", Operator.ADDITION, Operator.ADDITION, 107)
        );
    }

}


