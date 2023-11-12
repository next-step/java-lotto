package calculator;

import calculator.service.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("계산은 우선순위가 아닌 입력된 순서로 계산된다.")
    void 계산순서() throws Exception {
        String[] input = {"2", "+", "3", "*", "4"};
        assertThat(Calculator.calculate(input)).isEqualTo(20);
    }
}
