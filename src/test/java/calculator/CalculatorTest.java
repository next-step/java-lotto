package calculator;

import calculator.domain.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void 계산() {
        Calculator calculator = new Calculator();
        String[] tokens = "1 + 2".split(" ");

        for (String token : tokens) {
            calculator.calculate(token);
        }

        assertThat(calculator.getResult()).isEqualTo(3);
    }
}
