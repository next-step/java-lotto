package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void 계산() {
        Calculator calculator = new Calculator();
        String[] inputValues = "1 + 2".split(" ");

        for (String value : inputValues) {
            calculator.calculate(new InputValue(value));
        }

        assertThat(calculator.getResult()).isEqualTo(3);
    }
}
