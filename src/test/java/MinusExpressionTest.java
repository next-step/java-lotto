import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinusExpressionTest {

    @DisplayName("뺄셈을 합니다.")
    @Test
    void minusCalculate(){
        MinusExpression minusExpression = new MinusExpression(new VariableExpression('5'), new VariableExpression('2'));
        int result = minusExpression.calculate();
        Assertions.assertThat(result).isEqualTo(3);
    }
}
