package calculator;

import calculator.domain.VariableExpression;
import calculator.domain.MinusExpression;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinusExpressionTest {

    private final static VariableExpression ONE = new VariableExpression('1');
    private final static VariableExpression TWO = new VariableExpression('2');

    @DisplayName("뺄셈을 합니다.")
    @Test
    void minusCalculate(){
        MinusExpression minusExpression = new MinusExpression();
        VariableExpression result = minusExpression.calculate(ONE, TWO);
        Assertions.assertThat(result.value()).isEqualTo(-1);
    }
}
