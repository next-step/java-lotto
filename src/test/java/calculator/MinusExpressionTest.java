package calculator;

import calculator.domain.VariableExpression;
import calculator.domain.MinusExpression;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinusExpressionTest {

    @DisplayName("뺄셈을 합니다.")
    @Test
    void minusCalculate(){
        MinusExpression minusExpression = new MinusExpression(TestProperties.ONE, TestProperties.TWO);
        VariableExpression result = minusExpression.calculate();
        Assertions.assertThat(result.value()).isEqualTo(-1);
    }
}
