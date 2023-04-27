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

@DisplayName("뺄셈 연산 테스트")
class SubtractionOperationTest {
    @Test
    void 뺄셈연산기호가_일치하는지_확인할수있다() {
        Operator operator = Operator.SUBTRACTION;
        SubtractionOperation subtractionOperation = new SubtractionOperation();
        boolean isSupportSubtractionOperation = subtractionOperation.supports(operator);
        Assertions.assertThat(isSupportSubtractionOperation).isTrue();
    }

    @ParameterizedTest(name = "피연산자 객체를 전달하면 뺄셈연산이 수행된다")
    @MethodSource("subtractionOperationData")
    void calculate_AdditionWithDifferentOperands_ShouldReturnCorrectResult(Operand firstOperand, Operand nextOperand, int expectedResult) {
        SubtractionOperation subtractionOperation = new SubtractionOperation();
        int actualResult = subtractionOperation.calculate(firstOperand, nextOperand);
        assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> subtractionOperationData() {
        return Stream.of(
                Arguments.of(new Operand("4"), new Operand("3"), 1),
                Arguments.of(new Operand("0"), new Operand("0"), 0),
                Arguments.of(new Operand("1000"), new Operand("200"), 800),
                Arguments.of(new Operand("95"), new Operand("5"), 90),
                Arguments.of(new Operand("0"), new Operand("100"), -100)
        );
    }
}