import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DivideExpressionTest {

    @DisplayName("나눗셈을 합니다.")
    @Test
    void divideCalculate(){
        DivideExpression divideExpression = new DivideExpression(2,10);
        int result = divideExpression.calculate();
        assertThat(result).isEqualTo(5);
    }
}
