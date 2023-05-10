package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    void calculate() {
        int result = calculator.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }
}