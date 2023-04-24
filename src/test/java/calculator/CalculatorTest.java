package calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static calculator.Operator.ADD;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    @Test
    public void performAdditions() {
        List<Integer> operands = List.of(2, 3, 4);
        List<Operator> operators = List.of(ADD, ADD);

        Calculator calculator = new Calculator();
        var result = calculator.performSequentialArithmetics(operands, operators);

        assertThat(result).isEqualTo(9);
    }
}
