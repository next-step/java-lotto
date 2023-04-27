package calculator.domain.operation;

import calculator.domain.expression.Operand;
import calculator.domain.expression.Operator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("곱셈 연산 테스트")
class MultiplicationOperationTest {
    @Test
    void 뺄셈연산기호가_일치하는지_확인할수있다() {
        Operator operator = Operator.MULTIPLICATION;
        MultiplicationOperation multiplicationOperation = new MultiplicationOperation();
        boolean isSupportMultiplicationOperation = multiplicationOperation.supports(operator);
        Assertions.assertThat(isSupportMultiplicationOperation).isTrue();
    }

    @ParameterizedTest(name = "피연산자 객체를 전달하면 뺄셈연산이 수행된다")
    @MethodSource("multiplicationOperationData")
    void calculate_AdditionWithDifferentOperands_ShouldReturnCorrectResult(Operand firstOperand, Operand nextOperand, int expectedResult) {
        MultiplicationOperation multiplicationOperation = new MultiplicationOperation();
        int actualResult = multiplicationOperation.calculate(firstOperand, nextOperand);
        assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> multiplicationOperationData() {
        return Stream.of(
                Arguments.of(new Operand("4"), new Operand("3"), 12),
                Arguments.of(new Operand("0"), new Operand("0"), 0),
                Arguments.of(new Operand("80"), new Operand("1"), 80),
                Arguments.of(new Operand("100"), new Operand("90"), 9000),
                Arguments.of(new Operand("99999"), new Operand("0"), -0)
        );
    }
}