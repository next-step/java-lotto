package Lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    @Test
    void 계산하기() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate();
        assertThat(result).isEqualTo(0);
    }
}
