package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.MultiplicationExpression;
import calculator.domain.VariableExpression;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MultiplicationExpressionTest {


    @DisplayName("곱셈을 합니다.")
    @Test
    void multiplicationCalculate() {
        MultiplicationExpression multiplicationExpression = new MultiplicationExpression(TestProperties.ONE, TestProperties.TWO);
        VariableExpression result = multiplicationExpression.calculate();
        assertThat(result.value()).isEqualTo(2);
    }
}
