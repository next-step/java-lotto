package calculator.domain.calculator;

import calculator.domain.Calculable;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubtractionCalculatorTest {

    @Test
    void 빼기() {
        Calculable cal = new SubtractionCalculator();
        int preResult = 10;
        int operand = 10;

        assertThat(cal.calculate(preResult, operand)).isEqualTo(0);
    }
}
