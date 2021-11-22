package step_1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void shouldSplit() {
        String input = "1,2,3";
        Calculator calculator = new Calculator();
        calculator.split(input);

        assertThat(calculator.size()).isEqualTo(3);
    }

}