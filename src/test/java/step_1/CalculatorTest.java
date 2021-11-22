package step_1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void shouldSplitByComma() {
        String input = "1,2,3";
        Calculator calculator = new Calculator();
        calculator.split(input);

        assertThat(calculator.size()).isEqualTo(3);
    }

    @Test
    void shouldSplitByColon() {
        String input = "4:5:6";
        Calculator calculator = new Calculator();
        calculator.split(input);

        assertThat(calculator.size()).isEqualTo(3);
    }

    @Test
    void shouldNotSplitBlankString() {
        String input = "";
        Calculator calculator = new Calculator();
        calculator.split(input);
        calculator.sum();

        assertThat(calculator.size()).isEqualTo(1);
        assertThat(calculator.count()).isEqualTo(0);
    }
}