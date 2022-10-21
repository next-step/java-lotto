package caculator;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @Test
    void 연산_하나() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate(Arrays.asList("2", "+", "3"))).isEqualTo(5);
    }

    @Test
    void 연산_여러개() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate(Arrays.asList("2", "+", "3", "/", "5"))).isEqualTo(1);
    }
}