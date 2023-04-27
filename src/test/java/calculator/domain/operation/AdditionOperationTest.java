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

@DisplayName("덧셈 연산 테스트")
class AdditionOperationTest {

    @Test
    void 덧셈연산기호가_일치하는지_확인할수있다() {
        Operator operator = Operator.ADDITION;
        AdditionOperation additionOperation = new AdditionOperation();
        boolean isSupportAdditionOperation = additionOperation.supports(operator);
        Assertions.assertThat(isSupportAdditionOperation).isTrue();
    }

    @ParameterizedTest(name = "피연산자 객체를 전달하면 덧셈연산이 수행된다")
    @MethodSource("additionOperationData")
    void calculate_AdditionWithDifferentOperands_ShouldReturnCorrectResult(Operand firstOperand, Operand nextOperand, int expectedResult) {
        AdditionOperation additionOperation = new AdditionOperation();
        int actualResult = additionOperation.calculate(firstOperand, nextOperand);
        assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> additionOperationData() {
        return Stream.of(
                Arguments.of(new Operand("2"), new Operand("3"), 5),
                Arguments.of(new Operand("0"), new Operand("0"), 0),
                Arguments.of(new Operand("1000"), new Operand("200"), 1200),
                Arguments.of(new Operand("95"), new Operand("5"), 100),
                Arguments.of(new Operand("999"), new Operand("0"), 999)
        );
    }
}