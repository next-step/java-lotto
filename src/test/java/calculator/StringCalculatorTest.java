package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @Test
    void calculate() {
        int result = StringCalculator.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

}