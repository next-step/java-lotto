import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MultiplicationExpressionTest {

    @DisplayName("곱셈을 합니다.")
    @Test
    void multiplicationCalculate(){
        MultiplicationExpression multiplicationExpression = new MultiplicationExpression(2,3);
        int result = multiplicationExpression.calculate();
        assertThat(result).isEqualTo(6);
    }
}
