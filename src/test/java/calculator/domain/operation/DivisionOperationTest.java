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

@DisplayName("나눗셈 연산 테스트")
class DivisionOperationTest {
    @Test
    void 나눗셈연산기호가_일치하는지_확인할수있다() {
        Operator operator = Operator.DIVISION;
        DivisionOperation divisionOperation = new DivisionOperation();
        boolean isSupportSubtractionOperation = divisionOperation.supports(operator);
        Assertions.assertThat(isSupportSubtractionOperation).isTrue();
    }

    @Test
    void 두번째_피연산자가_영이면_나눗셈연산은_예외가_발생한다() {
        DivisionOperation divisionOperation = new DivisionOperation();
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> divisionOperation.calculate(new Operand("100"), new Operand("0")))
                .withMessage("Cannot divide by zero");
    }

    @ParameterizedTest(name = "피연산자 객체를 전달하면 뺄셈연산이 수행된다")
    @MethodSource("divisionOperationData")
    void calculate_AdditionWithDifferentOperands_ShouldReturnCorrectResult(Operand firstOperand, Operand nextOperand, int expectedResult) {
        DivisionOperation divisionOperation = new DivisionOperation();
        int actualResult = divisionOperation.calculate(firstOperand, nextOperand);
        assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> divisionOperationData() {
        return Stream.of(
                Arguments.of(new Operand("4"), new Operand("4"), 1),
                Arguments.of(new Operand("10"), new Operand("3"), 3),
                Arguments.of(new Operand("0"), new Operand("10"), 0),
                Arguments.of(new Operand("1"), new Operand("5"), 0),
                Arguments.of(new Operand("73"), new Operand("8"),9)
        );
    }
}
