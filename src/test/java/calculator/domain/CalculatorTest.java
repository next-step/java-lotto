package calculator.domain;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    void name() {
        List<Operand> operands = List.of(new Operand("3"), new Operand("3"));
        List<Operator> operators = List.of(Operator.PLUS);
        Expression expression = new Expression(operands, operators);

        Number result = Calculator.calculate(expression);
        assertThat(result.value()).isEqualTo(6);
    }
}
