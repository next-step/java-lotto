package calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    void 더하기_기능() {
        int result = calculator.plus(1,1);
        assertEquals(2, result);
    }

    @Test
    void 빼기_기능() {
        int result = calculator.minus(1, 1);
        assertEquals(0, result);
    }

    @Test
    void 곱하기_기능() {
        int result = calculator.multiply(3,4);
        assertEquals(12, result);
    }

    @Test
    void 나누기_기능() {
        int result = calculator.divide(4, 2);
        assertEquals(2, result);
    }

    @Test
    void 나누기는_정수로_한정한다() {
        assertThatIllegalArgumentException().isThrownBy(()-> {
            calculator.divide(4, 3);
        });
    }

    @Test
    void 연산자리스트가_주어지면_값을_계산한다() {
        List<Integer> operands = List.of(1,2);
        List<Operator> operators = List.of(Operator.ADD);
        assertEquals(3, calculator.calc(operands, operators));
    }

}
