package calculator.calculate;

import calculator.calc.Calculator;
import calculator.calc.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MulTest {

    @Test
    @DisplayName("값을 입력하면 곱셈을 반환한다.")
    public void mulTest(){
        int result = Operator.MULTIPLICATION.apply(1,2);

        assertThat(result).isEqualTo(2);
    }
}
