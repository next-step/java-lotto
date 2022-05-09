package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    Formula formula;

    @BeforeEach
    void setUp() {
        formula = new Formula("2 + 3 * 4 / 2");
    }

    @Test
    void 계산기() {
        assertThat(new Calculator(formula).execute()).isEqualTo(10);
    }
}
