package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.MultiplicationExpression;
import calculator.domain.VariableExpression;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MultiplicationExpressionTest {

    private final static VariableExpression ONE = new VariableExpression('1');
    private final static VariableExpression TWO = new VariableExpression('2');

    @DisplayName("곱셈을 합니다.")
    @Test
    void multiplicationCalculate() {
        MultiplicationExpression multiplicationExpression = new MultiplicationExpression();
        VariableExpression result = multiplicationExpression.calculate(ONE, TWO);
        assertThat(result.value()).isEqualTo(2);
    }
}
