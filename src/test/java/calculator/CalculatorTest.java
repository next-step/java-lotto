package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void 수식_계산() {
        Calculator calculator = new Calculator("2 + 13 * 4 / 2");
        int result = calculator.calculate();
        assertThat(result).isEqualTo(30);
    }
}
