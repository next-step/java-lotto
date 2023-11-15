package calculator;

import calculator.domain.AddExpression;
import calculator.domain.VariableExpression;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddExpressionTest {

    private final static VariableExpression ONE = new VariableExpression('1');
    private final static VariableExpression TWO = new VariableExpression('2');
    @DisplayName("덧셈을 합니다.")
    @Test
    void plusCalculate(){
        AddExpression addExpression = new AddExpression();
        VariableExpression result = addExpression.calculate(ONE, TWO);
        Assertions.assertThat(result.value()).isEqualTo(3);
    }
}
