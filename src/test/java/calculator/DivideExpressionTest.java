package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.DivideExpression;
import calculator.domain.VariableExpression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DivideExpressionTest {

    private final static VariableExpression ONE = new VariableExpression('4');
    private final static VariableExpression TWO = new VariableExpression('8');
    @DisplayName("나눗셈을 합니다.")
    @Test
    void divideCalculate(){
        DivideExpression divideExpression = new DivideExpression();
        VariableExpression result = divideExpression.calculate(ONE, TWO);
        assertThat(result.value()).isEqualTo(1);
    }
}
