package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void shouldSplitByComma() {
        String input = "1,2,3";
        Calculator calculator = new Calculator();
        calculator.calculate(input);

        assertThat(calculator.size()).isEqualTo(3);
    }

    @Test
    void shouldSplitByColon() {
        String input = "4:5:6";
        Calculator calculator = new Calculator();
        calculator.calculate(input);

        assertThat(calculator.size()).isEqualTo(3);
    }

    @Test
    void shouldReturnZeroWhenInputIsBlank() {
        String input = "";
        Calculator calculator = new Calculator();
        int sum = calculator.calculate(input);

        assertThat(sum).isEqualTo(0);
    }

    @Test
    void shouldReturnZeroWhenInputIsNull() {
        Calculator calculator = new Calculator();
        int sum = calculator.calculate(null);

        assertThat(sum).isEqualTo(0);
    }
}