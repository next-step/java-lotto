package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 0giri
 * @since : 2023/04/25
 */
public class CalculatorTest {

    @Test
    void name() {
        List<ExpressionElement> elements = new ArrayList<>();
        elements.add(new Operand("3"));
        elements.add(Operator.PLUS);
        elements.add(new Operand("3"));
        Expression expression = new Expression(elements);

        Number result = Calculator.calculate(expression);
        assertThat(result.value()).isEqualTo(6);
    }
}
