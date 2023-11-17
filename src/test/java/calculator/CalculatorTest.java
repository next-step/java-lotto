package calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void 더하기_기능() {
        List<Integer> operands = List.of(1, 2);
        List<Operator> operators = List.of(Operator.ADD);
        assertEquals(3, calculator.calc(operands, operators));
    }

    @Test
    void 빼기_기능() {
        List<Integer> operands = List.of(3, 2);
        List<Operator> operators = List.of(Operator.SUBTRACT);
        assertEquals(1, calculator.calc(operands, operators));
    }

    @Test
    void 곱하기_기능() {
        List<Integer> operands = List.of(5, 2);
        List<Operator> operators = List.of(Operator.MULTIPLY);
        assertEquals(10, calculator.calc(operands, operators));
    }

    @Test
    void 나누기_기능() {
        List<Integer> operands = List.of(4, 2);
        List<Operator> operators = List.of(Operator.DIVIDE);
        assertEquals(2, calculator.calc(operands, operators));
    }

    @Test
    void 나누기는_정수로_한정한다() {
        List<Integer> operands = List.of(4, 3);
        List<Operator> operators = List.of(Operator.DIVIDE);
        assertThatIllegalArgumentException().isThrownBy(()-> {
            calculator.calc(operands, operators);
        });
    }

    @Test
    void 연산자리스트가_주어진_순서대로_계산한다() {
        List<Integer> operands = List.of(1, 2, 5);
        List<Operator> operators = List.of(Operator.ADD, Operator.SUBTRACT);
        assertEquals(-2, calculator.calc(operands, operators));
    }

}
