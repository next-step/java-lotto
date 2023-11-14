import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MultiplicateExpressionTest {

    @DisplayName("뺄셈을 합니다.")
    @Test
    void plusCalculate(){
        MinusExpression minusExpression = new MinusExpression(5, 2);
        int result = minusExpression.calculate();
        Assertions.assertThat(result).isEqualTo(3);
    }
}
