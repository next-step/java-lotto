package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.DivideExpression;
import calculator.domain.VariableExpression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DivideExpressionTest {

    @DisplayName("나눗셈을 합니다.")
    @Test
    void divideCalculate(){
        DivideExpression divideExpression = new DivideExpression(TestProperties.ONE, TestProperties.TWO);
        VariableExpression result = divideExpression.calculate();
        assertThat(result.value()).isEqualTo(1);
    }
}
