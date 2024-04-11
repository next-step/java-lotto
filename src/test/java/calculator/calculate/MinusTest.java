package calculator.calculate;

import calculator.calc.Calculator;
import calculator.calc.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinusTest {

    @Test
    @DisplayName("값을 입력하면 뺄셈을 반환한다.")
    public void minusTest(){
        int result = Operator.SUBTRACTION.apply(3,2);

        assertThat(result).isEqualTo(-1);
    }
}
