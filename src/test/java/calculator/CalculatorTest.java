package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("식을 계산한 결과값을 리턴한다")
    public void 계산(){
        String text = "-1 + -3 - 1 * -2 / 2";
        Calculator calculator = new Calculator(text);
        assertThat(calculator.calculate()).isEqualTo(5);
    }
}